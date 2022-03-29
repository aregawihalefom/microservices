package com.mhazutcode.notification.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    private String message;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private LocalDateTime sentAt;

}