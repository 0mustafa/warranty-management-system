package com.warrantyManagement.warranty_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warrantyManagement.warranty_management.dto.DeviceDto;
import com.warrantyManagement.warranty_management.entity.Device;
import com.warrantyManagement.warranty_management.exception.ResourceNotFoundException;
import com.warrantyManagement.warranty_management.mapper.DeviceMapper;
import com.warrantyManagement.warranty_management.repository.DeviceRepository;
import com.warrantyManagement.warranty_management.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Override
	public DeviceDto createDevice(DeviceDto deviceDto) {
		
		Device device = DeviceMapper.mapToDevice(deviceDto);
		Device savedDevice = deviceRepository.save(device);
		
		return DeviceMapper.mapToDeviceDto(savedDevice);
	}

	@Override
	public DeviceDto getDeviceById(Long deviceId) {
		
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Device not found with given id: " + deviceId));
		
		return DeviceMapper.mapToDeviceDto(device);
	}

	@Override
	public List<DeviceDto> getAllDevices() {
		
		List<Device> devices = deviceRepository.findAll();
		
		return devices.stream().map(
				(device) -> DeviceMapper.mapToDeviceDto(device)).collect(Collectors.toList());
	}

	@Override
	public DeviceDto updateDevice(Long deviceId, DeviceDto updatedDevice) {
		
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Device not found with given id: " + deviceId));
		
		if(updatedDevice.getSerialNumber() != null) device.setSerialNumber(updatedDevice.getSerialNumber());
		if(updatedDevice.getBrand() != null) device.setBrand(updatedDevice.getBrand());
		if(updatedDevice.getModel() != null) device.setModel(updatedDevice.getModel());
		
		Device updatedDeviceObj = deviceRepository.save(device);
		
		return DeviceMapper.mapToDeviceDto(updatedDeviceObj);
	}

	@Override
	public void deleteDevice(Long deviceId) {
		
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Device not found with given id: " + deviceId));
		
		deviceRepository.delete(device);
		
	}
}
