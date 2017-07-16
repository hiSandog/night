package com.doudou.core;

import com.doudou.model.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by chenjiaming on 2017/7/9.
 */
@ControllerAdvice
public class SnowExceptionHandler {

    @ExceptionHandler(SnowException.class)
    public ResponseEntity<CommonResponse> handleRainException(SnowException e){
        return new ResponseEntity<>(new CommonResponse(e.getCode(), e.getMsg()), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> handleException(){
        return new ResponseEntity<>(new CommonResponse(500,"未知错误"), HttpStatus.OK);
    }

}