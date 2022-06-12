package com.miniapp.countryside.exception;

public class BizException extends  RuntimeException{
    private final Integer code;

    public BizException(ExceptionType exceptionType){

        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }
    public BizException(Integer code,String message){
        super(message);
        this.code=code;
    }
    public Integer getCode() {
        return code;
    }
}
