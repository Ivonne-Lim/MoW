package org.mm.mow.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


@ControllerAdvice
public class OverallExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ModelAndView handleRuntimeException(RuntimeException exception, WebRequest webRequest) {

        ModelAndView model = new ModelAndView("error");
        model.addObject("message", exception.getMessage());
		model.addObject("dateTime", LocalDateTime.now());
		return model;

    }

}
