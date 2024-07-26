package com.warrantyManagement.warranty_management.dto;

import java.time.LocalDate;

import com.warrantyManagement.warranty_management.entity.Device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyDto {
	private Long id;
	private Device device;
	private LocalDate purchaseDate;
	private String warrantyStatus;
}
