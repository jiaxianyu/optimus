package lfhfirst.exception;


public class BaseException extends RuntimeException{

    private int code = 0000;

    public BaseException(int code,String message){
        super(message);
        this.code=code;
    }

    public int getCode(){
        return code;
    }

}
