package com.warrantyManagement.warranty_management.dto;


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
}
