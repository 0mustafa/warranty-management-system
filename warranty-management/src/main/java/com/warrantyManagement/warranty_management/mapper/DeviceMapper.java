package com.warrantyManagement.warranty_management.mapper;

import com.warrantyManagement.warranty_management.dto.DeviceDto;
import com.warrantyManagement.warranty_management.entity.Device;

public class DeviceMapper {
	public static DeviceDto mapToDeviceDto(Device device) {
		return new DeviceDto(
				device.getId(),
				device.getSerialNumber(),
				device.getBrand(),
				device.getModel()
			);
	}
	
	public static Device mapToDevice(DeviceDto deviceDto) {
		return new Device(
				deviceDto.getId(),
				deviceDto.getSerialNumber(),
				deviceDto.getBrand(),
				deviceDto.getModel()
			);
	}
}
