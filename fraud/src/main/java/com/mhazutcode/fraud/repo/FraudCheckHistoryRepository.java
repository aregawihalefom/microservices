package com.mhazutcode.fraud.repo;

import com.mhazutcode.fraud.model.FraudChecksHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudChecksHistory, Integer> {
}
