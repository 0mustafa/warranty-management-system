/**
 **  This class provides a pattern for API responses.
**/

package com.warrantyManagement.warranty_management.utility;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse<T>{

	private boolean success = true;
	private int statusCode;
	private String statusMessage;
	private T data;
	private LocalDateTime timeStamp;
	
}
