package com.voting.exception;

import org.springframework.http.HttpStatus;

public class VoteException extends RuntimeException{

	private String message;
	
	private HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
			
	public VoteException(String message) {
		super(message);
		this.message = message;
	}

	public VoteException(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
