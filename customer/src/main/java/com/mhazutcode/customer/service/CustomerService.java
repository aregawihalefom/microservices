package com.mhazutcode.customer.service;

import com.mhazutcode.amqp.RabbitMQMessageProducer;
import com.mhazutcode.clients.fraud.FraudClient;
import com.mhazutcode.clients.fraud.dto.FraudCheckResponse;
import com.mhazutcode.clients.notification.NotificationClient;
import com.mhazutcode.clients.notification.dto.NotificationRequest;
import com.mhazutcode.customer.dto.CustomerRegistrationRequest;
import com.mhazutcode.customer.model.Customer;
import com.mhazutcode.customer.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer producer;

    public void save(CustomerRegistrationRequest registrationRequest) {

        Customer customer = Customer.builder()
                .firstname(registrationRequest.firstname())
                .lastname(registrationRequest.lastname())
                .email(registrationRequest.email())
                .build();

        // TODO : check if email is valid
        // TODO : check email is not taken
        // TODO : check customer is not fraudster
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudulent Customer");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Mhazutcodes ...",
                        customer.getFirstname())
        );

        // TODO:  Send async notification
        producer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
