package com.voting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.voting.exception.VoteException;

@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(VoteException.class)
	public ResponseEntity<VoteException> exceptionHandl(VoteException voteException) {
		return ResponseEntity.status(voteException.getStatus()).
				body(new VoteException(voteException.getMessage()));

	}
}
