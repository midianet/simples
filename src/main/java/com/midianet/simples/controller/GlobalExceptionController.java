package com.midianet.simples.controller;

import com.midianet.simples.exception.NegocioException;
import org.hibernate.metamodel.ValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(NegocioException.class)
    public ModelAndView handleNegocioException(final NegocioException e) {
        final ModelAndView model = new ModelAndView("error/generic_error");
        //model.addObject("errCode", e.getErrCode());
        //model.addObject("errMsg" , e.getErrMsg());
        return model;
    }

    @ExceptionHandler(ValidationException e)
    public ModelAndView

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(final Exception e) {
        ModelAndView model = new ModelAndView("error/generic_error");
        //model.addObject("errMsg", "this is Exception.class");
        return model;
    }

}