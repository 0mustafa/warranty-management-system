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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.warrantyManagement.warranty_management.dto.DeviceDto;
import com.warrantyManagement.warranty_management.service.DeviceService;
import com.warrantyManagement.warranty_management.utility.DeviceResponseEntity;
import com.warrantyManagement.warranty_management.utility.CustomResponse;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	// Add Device
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomResponse<DeviceResponseEntity> createDevice(@RequestBody DeviceDto deviceDto){
		
		DeviceResponseEntity deviceResponse = deviceService.createDevice(deviceDto);
		
		return new CustomResponse<DeviceResponseEntity>
		(true, HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase(), deviceResponse, LocalDateTime.now());
	}
	
	// Get Device By Id
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomResponse<DeviceResponseEntity> getDeviceById(@PathVariable("id") Long deviceId){
		DeviceResponseEntity deviceDto = deviceService.getDeviceById(deviceId);
		
		return new CustomResponse<DeviceResponseEntity>(true, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), deviceDto, LocalDateTime.now());
	}
	
	// Get Device By Serial Number
	@GetMapping("/serialNumber={id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomResponse<DeviceResponseEntity> getDeviceBySerialNumber(@PathVariable("id") String serialNumber){
		DeviceResponseEntity deviceDto = deviceService.getDeviceBySerialNumber(serialNumber);
		
		return new CustomResponse<DeviceResponseEntity>(true, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), deviceDto, LocalDateTime.now());
	}
	
	// Get All Devices
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public CustomResponse<List<DeviceResponseEntity>> getAllDevices(){
		List<DeviceResponseEntity> devices = deviceService.getAllDevices();
		
		return new CustomResponse<List<DeviceResponseEntity>>(true, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), devices, LocalDateTime.now());
	}
	
	// Check Warranties for All Devices
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public CustomResponse<String> checkAllWarranties(){
		deviceService.checkAllWarranties();
		
		return new CustomResponse<String>
		(true, HttpStatus.OK.value(), "All warranties of devices were successfully updated!", null, LocalDateTime.now());
	}
	
	// Update Device By Id
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomResponse<DeviceResponseEntity> updateDevice(@PathVariable("id") Long deviceId,
			@RequestBody DeviceDto deviceDto){
		DeviceResponseEntity updatedDevice = deviceService.updateDevice(deviceId, deviceDto);
		
		return new CustomResponse<DeviceResponseEntity>
		(true, HttpStatus.OK.value(), "Device was updated successfully with given id: " + deviceId, updatedDevice, LocalDateTime.now());
	}
	
	// Update Device By Serial Number
	@PutMapping("/serialNumber={id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomResponse<DeviceResponseEntity> updateDeviceBySerialNumber(@PathVariable("id") String serialNumber,
			@RequestBody DeviceDto deviceDto){
		DeviceResponseEntity updatedDevice = deviceService.updateDeviceBySerialNumber(serialNumber, deviceDto);
		
		return new CustomResponse<DeviceResponseEntity>
		(true, HttpStatus.OK.value(), "Device was updated successfully with given serial number: " + serialNumber, updatedDevice, LocalDateTime.now());
	}
	
	// Delete Device
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomResponse<String> deleteDevice(@PathVariable("id") Long deviceId){
		deviceService.deleteDevice(deviceId);
		
		return new CustomResponse<String>
		(true, HttpStatus.OK.value(), "Device was deleted successfully with given id: " + deviceId, null, LocalDateTime.now());
	}
	
	// Delete Device by Serial Number
	@DeleteMapping("/serialNumber={id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomResponse<String> deleteDeviceBySerialNumber(@PathVariable("id") String serialNumber){
		deviceService.deleteDeviceBySerialNumber(serialNumber);
		
		return new CustomResponse<String>
		(true, HttpStatus.OK.value(), "Device was deleted successfully with given serial number: " + serialNumber, null, LocalDateTime.now());
	}
}
