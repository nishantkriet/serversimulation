package com.example.serversimulation.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {
    private static final String GENERIC_MESSAGE = "There is something wrong with server. Please try after sometime.";
    private static final String GENERIC_REQUEST_PARAMETER_VALIDATION_MESSAGE = "Please enter mandatory data in valid format.";


    @ExceptionHandler(HandleAllException.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

        List<ApiValidationError> apiValidationErrors = new ArrayList<ApiValidationError>();

        //logger.info("Global Exception "+ex.getMessage().toString());

        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setDebugMessage(ex.getMessage());
        ApiValidationError apiValidationError = new ApiValidationError();
        apiValidationError.setField(ex.getMessage());
        apiValidationError.setMessage(ex.getMessage());
        apiValidationErrors.add(apiValidationError);
        apiError.setSubErrors(apiValidationErrors);
        return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)   {
//
//        List<ApiValidationError> apiValidationErrors=new ArrayList<ApiValidationError>();
//
//        //logger.info("Global Exception "+ex.getMessage().toString());
//
//        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
//        apiError.setMessage(ex.getMessage());
//        apiError.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//        apiError.setDebugMessage(ex.getMessage());
//        ApiValidationError apiValidationError=new ApiValidationError();
//        apiValidationError.setField(ex.getMessage());
//        apiValidationError.setMessage(ex.getMessage());
//        apiValidationErrors.add(apiValidationError);
//        apiError.setSubErrors(apiValidationErrors);
//        return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
//    }


    @ExceptionHandler(CustomNotFoundException.class)
    public final ResponseEntity<Object> profileNotFoundException(Exception ex, WebRequest request) {

        List<ApiValidationError> apiValidationErrors = new ArrayList<ApiValidationError>();
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        apiError.setHttpStatus(HttpStatus.NOT_FOUND);
        apiError.setDebugMessage(ex.getMessage());
        ApiValidationError apiValidationError = new ApiValidationError();
        apiValidationError.setField(ex.getMessage());
        apiValidationError.setMessage(ex.getMessage());
        apiValidationErrors.add(apiValidationError);
        apiError.setSubErrors(apiValidationErrors);
        return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ApiValidationError> apiValidationErrors = new ArrayList<ApiValidationError>();

        //Create generic error for request
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(GENERIC_REQUEST_PARAMETER_VALIDATION_MESSAGE);
        apiError.setDebugMessage(ex.getMessage());

        //Create specific error for field
        ApiValidationError apiValidationError = new ApiValidationError();
        apiValidationError.setObject(ex.getBindingResult().getFieldError().getObjectName());
        apiValidationError.setField(ex.getBindingResult().getFieldError().getField());
        apiValidationError.setRejectedValue(ex.getBindingResult().getFieldError().getRejectedValue() != null ? ex.getBindingResult().getFieldError().getRejectedValue().toString() : null);
        apiValidationError.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());

        apiValidationErrors.add(apiValidationError);

        apiError.setSubErrors(apiValidationErrors);

        //LogUtility.error(null, null, null, null, null, "Inside handleMethodArgumentNotValid() method.", ex);
        //LogUtility.error(HttpStatus.NOT_FOUND.value()+"", null, null, null, null, "Inside handleMethodArgumentNotValid() method.", null);


        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadReqeustException.class)//InvalidRequestException
    public final ResponseEntity<Object> badReqeustException(Exception ex, WebRequest request) {

        List<ApiValidationError> apiValidationErrors = new ArrayList<ApiValidationError>();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiError.setDebugMessage(ex.getMessage());
        ApiValidationError apiValidationError = new ApiValidationError();
        apiValidationError.setField(ex.getMessage());
        apiValidationError.setMessage(ex.getMessage());
        apiValidationErrors.add(apiValidationError);
        apiError.setSubErrors(apiValidationErrors);
        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

}
