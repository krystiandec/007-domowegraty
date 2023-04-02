package com.deczych.domowegraty.utils.enums;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {
    ITEM_NOT_FOUND_ID(100,HttpStatus.BAD_REQUEST,"ITEM WITH ID [@] NOT FOUND"),
    ITEM_NOT_FOUND_BARCODE(101,HttpStatus.BAD_REQUEST,"ITEM WITH BAR_CODE [@] NOT FOUND");


    private final int errorCode;
    private final HttpStatus status;
    private final String message;

    ExceptionEnum(int errorCode, HttpStatus status, String message) {
        this.errorCode = errorCode;
        this.status = status;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
