package com.warrantyManagement.warranty_management.utility;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResult <T>{

	private int statusCode;
	private boolean success = true;
	private String statusMessage;
	private T data;
	private LocalDateTime timeStamp;
	
}
