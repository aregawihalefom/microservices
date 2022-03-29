package com.mhazutcode.fraud.controller;

import com.mhazutcode.clients.fraud.dto.FraudCheckResponse;
import com.mhazutcode.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/frauds")
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        log.info("Fraud  Request from customer :"+customerId);
       return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
    }

}
