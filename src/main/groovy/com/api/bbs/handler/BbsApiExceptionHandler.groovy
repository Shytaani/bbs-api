package com.api.bbs.handler

import com.api.bbs.controller.response.ApiError
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice("com.api.bbs.controller")
class BbsApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource validationMessageSource

    @Override
    protected ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        def apiError = new ApiError(validationMessageSource.getMessage("invalid.request", null, LocaleContextHolder.locale))
        ex.bindingResult.fieldErrors.collect {
            apiError.addDetails(it.field, validationMessageSource.getMessage(it, LocaleContextHolder.locale))
        }
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST)
    }
}