package com.mhazutcode.clients.notification.dto;

import lombok.*;

@AllArgsConstructor
@Data
@ToString
@Builder
@NoArgsConstructor
public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String message;
}
