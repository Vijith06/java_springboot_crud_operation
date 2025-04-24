package com.codemagen.product.handler;

import com.codemagen.product.contants.MessageConstants;
import com.codemagen.product.contants.ResponseStatusConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle specific exception
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StatusDetail> handleIllegalArgumentException(IllegalArgumentException ex) {
        StatusDetail statusDetail = new StatusDetail();
        statusDetail.setStatus(ResponseStatusConstants.FAILURE_STATUS);
        statusDetail.setMessage(ex.getMessage());
        return new ResponseEntity<>(statusDetail, HttpStatus.BAD_REQUEST);
    }

    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StatusDetail> handleException(Exception ex) {
        StatusDetail statusDetail = new StatusDetail();
        statusDetail.setStatus(ResponseStatusConstants.FAILURE_STATUS);
        statusDetail.setMessage(MessageConstants.FAILURE_DESC);
        return new ResponseEntity<>(statusDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
