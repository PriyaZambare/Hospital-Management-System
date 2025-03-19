package com.Spring.Boot.HMS.docLogin.repository;

import com.Spring.Boot.HMS.docLogin.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
}