package com.warrantyManagement.warranty_management.mapper;

import com.warrantyManagement.warranty_management.dto.DeviceDto;
import com.warrantyManagement.warranty_management.entity.Device;
import com.warrantyManagement.warranty_management.repository.DeviceRepository;
import com.warrantyManagement.warranty_management.utility.DeviceResponseEntity;

public class DeviceMapper {
	public static DeviceDto mapToDeviceDto(Device device) {
		return new DeviceDto(
				device.getId(),
				device.getSerialNumber(),
				device.getBrand(),
				device.getModel(),
				device.getWarranty()
			);
	}
	
	public static Device mapToDevice(DeviceDto deviceDto) {
		return new Device(
				deviceDto.getId(),
				deviceDto.getSerialNumber(),
				deviceDto.getBrand(),
				deviceDto.getModel(),
				deviceDto.getWarranty()
			);
	}
	
	public static DeviceResponseEntity mapToDeviceResult(Device device) {
		return new DeviceResponseEntity(
				device.getId(),
				device.getSerialNumber(),
				device.getBrand(),
				device.getModel(),
				device.getWarranty().getPurchaseDate(),
				device.getWarranty().getWarrantyStatus()
			);
	}
}
