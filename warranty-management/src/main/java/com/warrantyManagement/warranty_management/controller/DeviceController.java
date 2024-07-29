package com.warrantyManagement.warranty_management.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warrantyManagement.warranty_management.dto.DeviceDto;
import com.warrantyManagement.warranty_management.service.DeviceService;
import com.warrantyManagement.warranty_management.utility.ServiceResult;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	// Add Device
	@PostMapping
	public ServiceResult<DeviceDto> createDevice(@RequestBody DeviceDto deviceDto){
		DeviceDto savedDevice = deviceService.createDevice(deviceDto);
		
		return new ServiceResult<DeviceDto>(HttpStatus.CREATED.value(), true, HttpStatus.CREATED.getReasonPhrase(), savedDevice, LocalDateTime.now());
	}
	
	// Get Device By Id
	@GetMapping("{id}")
	public ServiceResult<DeviceDto> getDeviceById(@PathVariable("id") Long deviceId){
		DeviceDto deviceDto = deviceService.getDeviceById(deviceId);
		
		return new ServiceResult<DeviceDto>(HttpStatus.OK.value(), true, HttpStatus.OK.getReasonPhrase(), deviceDto, LocalDateTime.now());
	}
	
	@GetMapping("/serialNumber={id}")
	public ServiceResult<DeviceDto> getDeviceBySerialNumber(@PathVariable("id") String serialNumber){
		DeviceDto deviceDto = deviceService.getDeviceBySerialNumber(serialNumber);
		
		return new ServiceResult<DeviceDto>
		(HttpStatus.OK.value(), true, HttpStatus.OK.getReasonPhrase(), deviceDto, LocalDateTime.now());
	}
	
	// Get All Devices
	@GetMapping
	public ServiceResult<List<DeviceDto>> getAllDevices(){
		List<DeviceDto> devices = deviceService.getAllDevices();
		
		return new ServiceResult<List<DeviceDto>>(HttpStatus.OK.value(), true, HttpStatus.OK.getReasonPhrase(), devices, LocalDateTime.now());
	}
	
	// Update Device By Id
	@PutMapping("{id}")
	public ServiceResult<DeviceDto> updateDevice(@PathVariable("id") Long deviceId,
			@RequestBody DeviceDto deviceDto){
		DeviceDto updatedDevice = deviceService.updateDevice(deviceId, deviceDto);
		
		return new ServiceResult<DeviceDto>(HttpStatus.OK.value(), true, "Device was updated successfully with given id: " + deviceId, updatedDevice, LocalDateTime.now());
	}
	
	// Update Device By Serial Number
	@PutMapping("/serialNumber={id}")
	public ServiceResult<DeviceDto> updateDeviceBySerialNumber(@PathVariable("id") String serialNumber,
			@RequestBody DeviceDto deviceDto){
		DeviceDto updatedDevice = deviceService.updateDeviceBySerialNumber(serialNumber, deviceDto);
		
		return new ServiceResult<DeviceDto>
		(HttpStatus.OK.value(), true, "Device was updated successfully with given serial number: " + serialNumber, updatedDevice, LocalDateTime.now());
	}
	
	// Delete Device
	@DeleteMapping("{id}")
	public ServiceResult<String> deleteDevice(@PathVariable("id") Long deviceId){
		deviceService.deleteDevice(deviceId);
		
		return new ServiceResult<String>(HttpStatus.OK.value(), true, "Device was deleted successfully with given id: " + deviceId, null, LocalDateTime.now());
	}
	
	// Delete Device by Serial Number
	@DeleteMapping("/serialNumber={id}")
	public ServiceResult<String> deleteDeviceBySerialNumber(@PathVariable("id") String serialNumber){
		deviceService.deleteDeviceBySerialNumber(serialNumber);
		
		return new ServiceResult<String>
		(HttpStatus.OK.value(), true, "Device was deleted successfully with given serial number: " + serialNumber, null, LocalDateTime.now());
	}
}
