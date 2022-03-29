package com.mhazutcode.notification.repo;


import com.mhazutcode.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
