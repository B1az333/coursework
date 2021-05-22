package kpi.zabelskyi.csdb.blaze.corp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class HandlingController {
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public String handlingConstraintViolationException(ConstraintViolationException exception){
        return exception.getLocalizedMessage();
    }
}