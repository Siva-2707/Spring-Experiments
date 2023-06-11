package com.siva.socialmediaapp.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private ErrorDetail body;
    private HttpStatus status;

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetail> handleAllException(Exception ex, WebRequest request) throws Exception {
        body = new ErrorDetail(LocalDateTime.now(), ex.getMessage(), ex.getStackTrace().toString());
        status = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<ErrorDetail>(body, status);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetail> handleForUserNotFoundException(Exception ex, WebRequest request)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement str : ex.getStackTrace()) {
            sb.append(str.toString());
            sb.append("/n");
        }

        return new ResponseEntity<ErrorDetail>(
                new ErrorDetail(LocalDateTime.now(), ex.getMessage(), sb.toString()),
                HttpStatus.NOT_FOUND);
    }

}
