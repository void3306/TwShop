package com.api.common.handler;

import com.api.common.enums.ErrorMsg;
import com.api.common.exception.ParamException;
import com.api.model.vo.ResultVo;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * controller的方法参数错误异常
     *
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo MethodArgumentNotVaildExceptionHandler(MethodArgumentNotValidException e){


        Map<String,String> collect = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));

        return ResultVo.fail(ErrorMsg.PARAM_ERROR,collect);
    }
    /**
     *   request  body的错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultVo HttpMessageNotReadableExceptionHandler(){
       return  ResultVo.fail(ErrorMsg.MISSING_PARAMETER,"requestbody错误!");
    }
    /**
     *   url缺少参数
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVo MissingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e ){
        return  ResultVo.fail(ErrorMsg.MISSING_PARAMETER,"缺少参数!"+e.getParameterName());
    }

    @ExceptionHandler(MissingRequestCookieException.class)
    public ResultVo MissingRequestCookieExceptionHandler(){

        return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
    }


    @ExceptionHandler(ParamException.class)
    public ResultVo ParamExceptionHandler(ParamException e){

        return ResultVo.fail(ErrorMsg.PARAM_ERROR,e.getMap());
    }


    //复杂自定义异常





}
