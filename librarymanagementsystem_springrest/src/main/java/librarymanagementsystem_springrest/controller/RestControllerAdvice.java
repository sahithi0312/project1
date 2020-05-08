package librarymanagementsystem_springrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import librarymanagementsystem_springrest.dto.LmsResponse;
import librarymanagementsystem_springrest.exception.LMSException;

public class RestControllerAdvice {
	
	@ExceptionHandler
	public LmsResponse myExceptionHandler(LMSException lmsException) {
		LmsResponse response = new LmsResponse();
		response.setError(true);
		response.setMessage(lmsException.getMessage());
		return response;
	}

}
