package com.warrantyManagement.warranty_management.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warrantyManagement.warranty_management.dto.WarrantyDto;
import com.warrantyManagement.warranty_management.entity.Warranty;
import com.warrantyManagement.warranty_management.exception.EmptyValueException;
import com.warrantyManagement.warranty_management.exception.ResourceNotFoundException;
import com.warrantyManagement.warranty_management.mapper.WarrantyMapper;
import com.warrantyManagement.warranty_management.repository.WarrantyRepository;
import com.warrantyManagement.warranty_management.service.WarrantyService;

@Service
public class WarrantyServiceImpl implements WarrantyService{
	
	@Autowired
	private WarrantyRepository warrantyRepository;
	
	public String checkWarranty(LocalDate purchaseDate) {
		return (Duration.between(purchaseDate.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays() > 730) ? "The warranty expired!" : "The warranty continous";
	}

	@Override
	public WarrantyDto createWarranty(WarrantyDto warrantyDto) {
		
		Warranty warranty = WarrantyMapper.mapToWarranty(warrantyDto);
		
		if(warranty.getPurchaseDate().toString().isEmpty() || 
				warranty.getDevice().getSerialNumber().isEmpty() ||
				warranty.getDevice().getBrand().isEmpty() ||
				warranty.getDevice().getModel().isEmpty()) {
			throw new EmptyValueException("You should fill all fields!");
		}else {
			String status = this.checkWarranty(warranty.getPurchaseDate());
			warranty.setWarrantyStatus(status);
			
			try {
				warrantyRepository.save(warranty);
				
			} catch (Exception e) {
				throw new ResourceNotFoundException(e.getMessage());
			}
		}
		
		return WarrantyMapper.mapToWarrantyDto(warranty);
	}

	@Override
	public WarrantyDto getWarrantyById(Long warrantyId) {
		
		Warranty warranty = warrantyRepository.findById(warrantyId)
				.orElseThrow(
						() -> new ResourceNotFoundException("Warranty record was not found with given id: " + warrantyId));
		
		return WarrantyMapper.mapToWarrantyDto(warranty);
	}

	@Override
	public WarrantyDto getWarrantyByDeviceId(Long deviceId) {
		
		List<WarrantyDto> warranties = this.getAllWarranties();
		
		WarrantyDto warrantyDto = warranties.stream()
				.filter((warranty) -> warranty.getDevice().getId() == deviceId)
				.findAny()
				.orElseThrow(() -> new ResourceNotFoundException("Warranty record was not found with given id: " + deviceId));
		Warranty warranty = WarrantyMapper.mapToWarranty(warrantyDto);
		
		return WarrantyMapper.mapToWarrantyDto(warranty);
	}

	@Override
	public List<WarrantyDto> getAllWarranties() {
		
		List<Warranty> warranties = warrantyRepository.findAll();
		
		return warranties.stream().map(
				(warranty) -> WarrantyMapper.mapToWarrantyDto(warranty)).collect(Collectors.toList());
	}

	@Override
	public WarrantyDto updateWarrantyById(Long warrantyId, WarrantyDto warrantyDto) {
		
		Warranty warranty = WarrantyMapper.mapToWarranty(this.getWarrantyById(warrantyId));
		
		if(warrantyDto.getDevice() != null) warranty.setDevice(warrantyDto.getDevice());
		if(warrantyDto.getPurchaseDate() != null) warranty.setPurchaseDate(warrantyDto.getPurchaseDate());
		if(warrantyDto.getWarrantyStatus() != null) warranty.setWarrantyStatus(warrantyDto.getWarrantyStatus());
		
		// Check the warranty status
		warranty.setWarrantyStatus(this.checkWarranty(warranty.getPurchaseDate()));
		
		Warranty savedWarranty = warrantyRepository.save(warranty);
		
		return WarrantyMapper.mapToWarrantyDto(savedWarranty);
	}

	@Override
	public WarrantyDto updateWarrantyByDeviceID(Long deviceId, WarrantyDto warrantyDto) {
		
		Warranty warranty = WarrantyMapper.mapToWarranty(this.getWarrantyByDeviceId(deviceId));
		
		if(warrantyDto.getDevice() != null) warranty.setDevice(warrantyDto.getDevice());
		if(warrantyDto.getPurchaseDate() != null) warranty.setPurchaseDate(warrantyDto.getPurchaseDate());
		if(warrantyDto.getWarrantyStatus() != null) warranty.setWarrantyStatus(warrantyDto.getWarrantyStatus());
		
		// Check the warranty status
		warranty.setWarrantyStatus(this.checkWarranty(warranty.getPurchaseDate()));
		
		Warranty savedWarranty = warrantyRepository.save(warranty);
		
		return WarrantyMapper.mapToWarrantyDto(savedWarranty);
	}

	@Override
	public void deleteWarrantyById(Long warrantyId) {
		
		Warranty warranty = WarrantyMapper.mapToWarranty(this.getWarrantyById(warrantyId));
		
		warrantyRepository.delete(warranty);
		
	}

	@Override
	public void deleteWarrantyByDeviceId(Long deviceId) {
		
		Warranty warranty = WarrantyMapper.mapToWarranty(this.getWarrantyByDeviceId(deviceId));
		
		warrantyRepository.delete(warranty);
		
	}
}
