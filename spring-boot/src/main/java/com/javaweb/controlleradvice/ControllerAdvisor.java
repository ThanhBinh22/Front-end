package com.javaweb.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.bean.ErrorDetail;
import com.javaweb.customexception.FileRequiredException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ErrorDetail> handleArithmeticException(ArithmeticException ex, WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Số nguyên sao mà chia cho 0 được thế anh?");
		errorDetail.setDetails(details);
		return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(FileRequiredException.class)
	public ResponseEntity<ErrorDetail> handleFileRequiredException(FileRequiredException ex, WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Tên tòa nhà hoặc số hầm không được thiếu khi gửi về cho BE");
		errorDetail.setDetails(details);
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}

}
