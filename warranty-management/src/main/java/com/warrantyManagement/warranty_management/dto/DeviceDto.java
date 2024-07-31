package com.warrantyManagement.warranty_management.dto;


import com.warrantyManagement.warranty_management.entity.Warranty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {
	private Long id;
	private String SerialNumber;
	private String brand;
	private String model;
	private Warranty warranty;
}
