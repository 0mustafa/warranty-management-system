package com.warrantyManagement.warranty_management.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warrantyManagement.warranty_management.dto.DeviceDto;
import com.warrantyManagement.warranty_management.entity.Device;
import com.warrantyManagement.warranty_management.entity.Warranty;
import com.warrantyManagement.warranty_management.exception.DateTimeException;
import com.warrantyManagement.warranty_management.exception.EmptyValueException;
import com.warrantyManagement.warranty_management.exception.GeneralException;
import com.warrantyManagement.warranty_management.exception.ResourceNotFoundException;
import com.warrantyManagement.warranty_management.mapper.DeviceMapper;
import com.warrantyManagement.warranty_management.repository.DeviceRepository;
import com.warrantyManagement.warranty_management.repository.WarrantyRepository;
import com.warrantyManagement.warranty_management.service.DeviceService;
import com.warrantyManagement.warranty_management.utility.DeviceResponseEntity;

import jakarta.transaction.Transactional;

@Service
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private WarrantyRepository warrantyRepository;
	
	public String checkWarranty(LocalDate purchaseDate) {
		return (Duration.between(purchaseDate.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays() > 730) ? "The warranty expired!" : "The warranty continues";
	}
	
	public boolean isValidLocalDate(String date) {
		try {
			LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Override
	@Transactional
	public DeviceResponseEntity createDevice(DeviceDto deviceDto) {
		
		Device device = DeviceMapper.mapToDevice(deviceDto);
		
		if(device.getSerialNumber() == null || device.getSerialNumber().isEmpty()
				|| device.getModel() == null || device.getModel().isEmpty()
				|| device.getBrand() == null || device.getBrand().isEmpty()
				|| device.getWarranty().getPurchaseDate() == null || device.getWarranty().getPurchaseDate().toString().isEmpty()) {
			throw new EmptyValueException("You should fill all fields!");
		}if(!this.isValidLocalDate(device.getWarranty().getPurchaseDate().toString())){
			throw new DateTimeException();
		}
		else {
			
			Device savedDevice = new Device();
			
			try {
				// save to db
				savedDevice = deviceRepository.save(device);
				
				Warranty warranty = new Warranty();
				warranty.setDeviceId(savedDevice);
				warranty.setPurchaseDate(savedDevice.getWarranty().getPurchaseDate());
				warranty.setWarrantyStatus(this.checkWarranty(savedDevice.getWarranty().getPurchaseDate()));
				
				// save to db
				warrantyRepository.save(warranty);
				
				savedDevice.setWarranty(warranty);
				
				return DeviceMapper.mapToDeviceResult(savedDevice);
			} catch (Exception e) {
				throw new GeneralException(e.getMessage());
			}
			
		}
		
	}

	@Override
	public DeviceResponseEntity getDeviceById(Long deviceId) {
		
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Device not found with given id: " + deviceId));
		
		return DeviceMapper.mapToDeviceResult(device);
	}
	
	@Override
	public DeviceResponseEntity getDeviceBySerialNumber(String serialNumber) {
		
		Device device = deviceRepository.findBySerialNumber(serialNumber);
		
		if(device == null) {
			throw new ResourceNotFoundException("Device not found with given serial number:" + serialNumber);
		}else {
			return DeviceMapper.mapToDeviceResult(device);
		}
		
	}

	@Override
	public List<DeviceResponseEntity> getAllDevices() {
		
		List<Device> devices = deviceRepository.findAll();
		
		return devices.stream().map(
				(device) -> DeviceMapper.mapToDeviceResult(device)).collect(Collectors.toList());
	}
	
	@Override
	public void checkAllWarranties() {
		List<Device> devices = deviceRepository.findAll();
		
		devices.stream().map(
				(device) -> this.updateDevice(device.getId(), DeviceMapper.mapToDeviceDto(device)));
		
	}

	@Override
	public DeviceResponseEntity updateDevice(Long deviceId, DeviceDto updatedDevice) {
		
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Device not found with given id: " + deviceId));
		
		if(updatedDevice.getWarranty().getPurchaseDate() == null 
				|| updatedDevice.getWarranty().getPurchaseDate().toString().isEmpty()
				|| !this.isValidLocalDate(updatedDevice.getWarranty().getPurchaseDate().toString())) {
			throw new DateTimeException();
		}
		
		if(updatedDevice.getSerialNumber() != null) device.setSerialNumber(updatedDevice.getSerialNumber());
		if(updatedDevice.getBrand() != null) device.setBrand(updatedDevice.getBrand());
		if(updatedDevice.getModel() != null) device.setModel(updatedDevice.getModel());
		if(updatedDevice.getWarranty().getPurchaseDate() != null 
				&& this.isValidLocalDate(updatedDevice.getWarranty().getPurchaseDate().toString())
				&& !updatedDevice.getWarranty().getPurchaseDate().toString().isEmpty()) {
			device.getWarranty().setPurchaseDate(updatedDevice.getWarranty().getPurchaseDate());
			// Check the warranty status
			device.getWarranty().setWarrantyStatus(this.checkWarranty(updatedDevice.getWarranty().getPurchaseDate()));;
		}
		
		Device updatedDeviceObj = deviceRepository.save(device);
		
		return DeviceMapper.mapToDeviceResult(updatedDeviceObj);
	}
	
	@Override
	public DeviceResponseEntity updateDeviceBySerialNumber(String serialNumber, DeviceDto updatedDevice) {
		
		Device device = deviceRepository.findBySerialNumber(serialNumber);
		
		if(device == null) {
			throw new ResourceNotFoundException("Device not found with given serial number: " + serialNumber);
		}if(updatedDevice.getWarranty().getPurchaseDate() == null 
				|| updatedDevice.getWarranty().getPurchaseDate().toString().isEmpty()
				|| !this.isValidLocalDate(updatedDevice.getWarranty().getPurchaseDate().toString())) {
			throw new DateTimeException();
		}else {
			if(updatedDevice.getSerialNumber() != null) device.setSerialNumber(updatedDevice.getSerialNumber());
			if(updatedDevice.getBrand() != null) device.setBrand(updatedDevice.getBrand());
			if(updatedDevice.getModel() != null) device.setModel(updatedDevice.getModel());
			if(updatedDevice.getWarranty().getPurchaseDate() != null
					&& this.isValidLocalDate(updatedDevice.getWarranty().getPurchaseDate().toString())
					&& !updatedDevice.getWarranty().getPurchaseDate().toString().isEmpty()) {
				device.getWarranty().setPurchaseDate(updatedDevice.getWarranty().getPurchaseDate());
				// Check the warranty status
				device.getWarranty().setWarrantyStatus(this.checkWarranty(updatedDevice.getWarranty().getPurchaseDate()));;
			}
			
			Device updatedDeviceObj = deviceRepository.save(device);
			
			return DeviceMapper.mapToDeviceResult(updatedDeviceObj);
		}
		
	}

	@Override
	public void deleteDevice(Long deviceId) {
		
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Device not found with given id: " + deviceId));
		
		warrantyRepository.delete(device.getWarranty());
		deviceRepository.delete(device);
		
	}
	
	@Override
	public void deleteDeviceBySerialNumber(String serialNumber) {
		
		Device device = deviceRepository.findBySerialNumber(serialNumber);
		
		if(device == null) {
			throw new ResourceNotFoundException("Device not found with given serial number: " + serialNumber);
		}else {
			warrantyRepository.delete(device.getWarranty());
			deviceRepository.delete(device);
		}
		
	}
}
