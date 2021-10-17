package com.group3.shoesshop.repository;

import com.group3.shoesshop.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, String> {
}
