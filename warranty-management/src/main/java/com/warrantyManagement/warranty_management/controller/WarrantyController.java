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

import com.warrantyManagement.warranty_management.dto.WarrantyDto;
import com.warrantyManagement.warranty_management.service.WarrantyService;
import com.warrantyManagement.warranty_management.utility.ServiceResult;

@RestController
@RequestMapping("/api/warranties")
public class WarrantyController {
	
	@Autowired
	private WarrantyService warrantyService;
	
	// Add Warranty
	@PostMapping
	public ServiceResult<WarrantyDto> createWarranty(@RequestBody WarrantyDto warrantyDto){
		WarrantyDto savedWarranty = warrantyService.createWarranty(warrantyDto);
		
		return new ServiceResult<WarrantyDto>
		(HttpStatus.CREATED.value(), true, HttpStatus.CREATED.getReasonPhrase(), savedWarranty, LocalDateTime.now());
	}
	
	// Get Warranty By Id
	@GetMapping("{id}")
	public ServiceResult<WarrantyDto> getWarrantyById(@PathVariable("id") Long warrantyId){
		WarrantyDto warrantyDto = warrantyService.getWarrantyById(warrantyId);
		
		return new ServiceResult<WarrantyDto>
		(HttpStatus.OK.value(), true, HttpStatus.OK.getReasonPhrase(), warrantyDto, LocalDateTime.now());
	}
	
	// Get Warranty By Device Id
	@GetMapping("/deviceId={id}")
	public ServiceResult<WarrantyDto> getWarrantyByDeviceId(@PathVariable("id") Long deviceId){
		WarrantyDto warrantyDto = warrantyService.getWarrantyByDeviceId(deviceId);
		
		return new ServiceResult<WarrantyDto>
		(HttpStatus.OK.value(), true, HttpStatus.OK.getReasonPhrase(), warrantyDto, LocalDateTime.now());
	}
	
	// Get All Warranties
	@GetMapping
	public ServiceResult<List<WarrantyDto>> getAllWarranties(){
		List<WarrantyDto> warranties = warrantyService.getAllWarranties();
		
		return new ServiceResult<List<WarrantyDto>>
		(HttpStatus.OK.value(), true, HttpStatus.OK.getReasonPhrase(), warranties, LocalDateTime.now());
	}
	
	@PutMapping("{id}")
	public ServiceResult<WarrantyDto> updateWarrantyById(@PathVariable("id") Long warrantyId,
			@RequestBody WarrantyDto warrantyDto){
		WarrantyDto updatedWarranty = warrantyService.updateWarrantyById(warrantyId, warrantyDto);
		
		return new ServiceResult<WarrantyDto>
		(HttpStatus.OK.value(), true, "Warranty record was updated with given warranty id: " + warrantyId, updatedWarranty, LocalDateTime.now());
	}
	
	@PutMapping("/deviceId={id}")
	public ServiceResult<WarrantyDto> updateWarrantyByDeviceId(@PathVariable("id") Long deviceId,
			@RequestBody WarrantyDto warrantyDto){
		WarrantyDto updatedWarranty = warrantyService.updateWarrantyByDeviceID(deviceId, warrantyDto);
		
		return new ServiceResult<WarrantyDto>
		(HttpStatus.OK.value(), true, "Warranty record was updated with given device id: " + deviceId, updatedWarranty, LocalDateTime.now());
	}
	
	@DeleteMapping("{id}")
	public ServiceResult<String> deleteWarrantyById(@PathVariable("id") Long warrantyId){
		warrantyService.deleteWarrantyById(warrantyId);
		
		return new ServiceResult<String>
		(HttpStatus.OK.value(), true, "Warranty record was deleted with given warranty id" + warrantyId, null, LocalDateTime.now());
	}
	
	@DeleteMapping("/deviceId={id}")
	public ServiceResult<String> deleteWarrantyByDeviceId(@PathVariable("id") Long deviceId){
		warrantyService.deleteWarrantyByDeviceId(deviceId);
		
		return new ServiceResult<String>
		(HttpStatus.OK.value(), true, "Warranty record was deleted with given device id" + deviceId, null, LocalDateTime.now());
	}
}
