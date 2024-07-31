package com.warrantyManagement.warranty_management.mapper;

import com.warrantyManagement.warranty_management.dto.WarrantyDto;
import com.warrantyManagement.warranty_management.entity.Warranty;

public class WarrantyMapper {
	
	public static WarrantyDto mapToWarrantyDto(Warranty warranty) {
		return new WarrantyDto(
				warranty.getId(),
				warranty.getDeviceId(),
				warranty.getPurchaseDate(),
				warranty.getWarrantyStatus()
			);
	}
	
	public static Warranty mapToWarranty(WarrantyDto warrantyDto) {
		return new Warranty(
				warrantyDto.getId(),
				warrantyDto.getDeviceId(),
				warrantyDto.getPurchaseDate(),
				warrantyDto.getWarrantyStatus()
			);
	}
}
