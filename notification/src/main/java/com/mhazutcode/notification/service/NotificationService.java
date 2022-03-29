package com.mhazutcode.notification.service;

import com.mhazutcode.clients.notification.dto.NotificationRequest;
import com.mhazutcode.notification.model.Notification;
import com.mhazutcode.notification.repo.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest request){
       notificationRepository.save(
               Notification.builder()
                       .toCustomerEmail(request.getToCustomerEmail())
                       .toCustomerId(request.getToCustomerId())
                       .sender("Mhazutcodes")
                       .message(request.getMessage())
                       .sentAt(LocalDateTime.now())
                       .build()
       );
    }
}
