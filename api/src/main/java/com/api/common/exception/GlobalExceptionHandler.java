package com.api.common.exception;

import com.api.common.annotation.DisableBaseResponse;
import com.api.common.enums.ErrorMsg;
import com.api.model.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@ResponseBody
//@RestControllerAdvice
public class GlobalExceptionHandler {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @ExceptionHandler(value = Exception.class)
        @DisableBaseResponse
        public Object handleException(Exception e) {
            if (e.getClass().equals(AccessDeniedException.class)){
                return ResultVo.fail(ErrorMsg.NO_ACCESS);
            }
            logger.error(e.getMessage());
            return ResultVo.error(400, e.getMessage());
        }
}
