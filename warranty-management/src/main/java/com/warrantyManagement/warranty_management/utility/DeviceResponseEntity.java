/**
 **  This class provides a pattern for device datas.  
**/
package com.warrantyManagement.warranty_management.utility;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponseEntity {

	private Long deviceId;
	private String serialNumber;
	private String brand;
	private String model;
	private LocalDate purchaseDate;
	private String warrantyStatus;
	
}
