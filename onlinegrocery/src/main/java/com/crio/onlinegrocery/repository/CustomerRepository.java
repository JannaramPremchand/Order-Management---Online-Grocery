package com.crio.onlinegrocery.repository;

import com.crio.onlinegrocery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
