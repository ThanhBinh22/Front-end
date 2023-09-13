package com.javaweb.customexception;

public class FileRequiredException extends RuntimeException {
	public FileRequiredException(String errorMessage) {
		super(errorMessage);
	}
}
