package com.group3.shoesshop.repository;

import com.group3.shoesshop.entity.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Integer> {
}
