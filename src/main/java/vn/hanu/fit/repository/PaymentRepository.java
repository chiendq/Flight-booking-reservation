package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

