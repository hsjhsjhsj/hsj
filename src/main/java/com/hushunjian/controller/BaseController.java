package com.hushunjian.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {  
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    private static String STATUS = "status";
    private static String BODY = "body";
    private static String MESSAGE = "message";

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, Object> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, Object> errors = new HashMap<String, Object>();
        if (e.getBindingResult().hasErrors()) {
            for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
                String code = objectError.getCodes()[1];
                String field = code.replaceAll("^.*\\.", "");
                errors.put(STATUS, "4000");
                String message = String.format("%s %s", field, objectError.getDefaultMessage());
                Map<String, Object> body = new HashMap<String, Object>();
                body.put(MESSAGE, message);
                errors.put(BODY, body);
                break;
            }
        }
        return errors;
    }

    public Object success(Object body) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put(STATUS, 2000);
        response.put(BODY, body);
        return response;
    }

    public Object success() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put(STATUS, 2000);
        Map<String, Object> body = new HashMap<String, Object>();
        response.put(BODY, body);
        return response;
    }
}