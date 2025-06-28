package com.invenco.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	private int status;
	private String details;
	private String message;
	private LocalDateTime timestamp = LocalDateTime.now();

	public ErrorResponse(int status, String details, String message) {
		super();
		this.status = status;
		this.details = details;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
