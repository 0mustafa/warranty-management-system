package com.warrantyManagement.warranty_management.service;

import java.util.List;

import com.warrantyManagement.warranty_management.dto.DeviceDto;

public interface DeviceService {
	DeviceDto createDevice(DeviceDto deviceDto);
	
	DeviceDto getDeviceById(Long deviceId);
	
	DeviceDto getDeviceBySerialNumber(String serialNumber);
	
	List<DeviceDto> getAllDevices();
	
	DeviceDto updateDevice(Long deviceId, DeviceDto updatedDevice);
	
	DeviceDto updateDeviceBySerialNumber(String serialNumber, DeviceDto updatedDevice);
	
	void deleteDevice(Long deviceId);
	
	void deleteDeviceBySerialNumber(String serialNumber);
}
