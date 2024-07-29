package com.warrantyManagement.warranty_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warrantyManagement.warranty_management.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long>{
	Device findBySerialNumber(String serialNumber);
}
