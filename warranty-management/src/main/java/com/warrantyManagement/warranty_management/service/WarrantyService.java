package com.warrantyManagement.warranty_management.service;

import java.util.List;

import com.warrantyManagement.warranty_management.dto.WarrantyDto;

public interface WarrantyService {
	WarrantyDto createWarranty(WarrantyDto warrantyDto);
	
	WarrantyDto getWarrantyById(Long warrantyId);
	
	WarrantyDto getWarrantyByDeviceId(Long deviceId);
	
	List<WarrantyDto> getAllWarranties();
	
	WarrantyDto updateWarrantyById(Long warrantyId, WarrantyDto warrantyDto);
	
	WarrantyDto updateWarrantyByDeviceID(Long deviceId, WarrantyDto warrantyDto);
	
	void deleteWarrantyById(Long warrantyId);
	
	void deleteWarrantyByDeviceId(Long deviceId);
}
