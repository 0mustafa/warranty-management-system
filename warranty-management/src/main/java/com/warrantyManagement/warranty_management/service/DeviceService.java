package com.warrantyManagement.warranty_management.service;

import java.util.List;

import com.warrantyManagement.warranty_management.dto.DeviceDto;
import com.warrantyManagement.warranty_management.utility.DeviceResponseEntity;

public interface DeviceService {
	DeviceResponseEntity createDevice(DeviceDto deviceDto);
	
	DeviceResponseEntity getDeviceById(Long deviceId);
	
	DeviceResponseEntity getDeviceBySerialNumber(String serialNumber);
	
	List<DeviceResponseEntity> getAllDevices();

	void checkAllWarranties();
	
	DeviceResponseEntity updateDevice(Long deviceId, DeviceDto updatedDevice);
	
	DeviceResponseEntity updateDeviceBySerialNumber(String serialNumber, DeviceDto updatedDevice);
	
	void deleteDevice(Long deviceId);
	
	void deleteDeviceBySerialNumber(String serialNumber);
}
