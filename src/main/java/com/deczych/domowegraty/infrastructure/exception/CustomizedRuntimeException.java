package com.deczych.domowegraty.infrastructure.exception;

import com.deczych.domowegraty.utils.enums.ExceptionEnum;
import org.springframework.http.HttpStatus;

public class CustomizedRuntimeException extends RuntimeException {
    private final static String placeholder = "@";

    private HttpStatus status;
    private int errorCode;

    public CustomizedRuntimeException() {
    }

    public CustomizedRuntimeException(String message) {
        super(message);
    }
    public CustomizedRuntimeException(ExceptionEnum exceptionEnum) {
        this(exceptionEnum.getMessage());
        this.errorCode = exceptionEnum.getErrorCode();
        this.status = exceptionEnum.getStatus();
    }

    public CustomizedRuntimeException(ExceptionEnum exceptionEnum, String msg) {
        this(exceptionEnum.getMessage().replace(placeholder, msg));
        this.errorCode = exceptionEnum.getErrorCode();
        this.status = exceptionEnum.getStatus();
    }
    public CustomizedRuntimeException(ExceptionEnum exceptionEnum, Long msg) {
        this(exceptionEnum.getMessage().replace(placeholder, String.valueOf(msg)));
        this.errorCode = exceptionEnum.getErrorCode();
        this.status = exceptionEnum.getStatus();
    }

}
