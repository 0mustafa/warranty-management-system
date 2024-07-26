package com.warrantyManagement.warranty_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warrantyManagement.warranty_management.entity.Warranty;

public interface WarrantyRepository extends JpaRepository<Warranty, Long>{
	
}
