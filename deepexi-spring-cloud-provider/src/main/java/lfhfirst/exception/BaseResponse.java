package lfhfirst.exception;

public class BaseResponse {
    private Boolean success;

    private String code;
    private String message;

    private String stack;

    public static BaseResponse result(Boolean success,String code, String message) {
        return new BaseResponse(success,code, message);
    }

    public static BaseResponse result(Boolean success, String message) {
        return new BaseResponse(success, message);
    }

    public BaseResponse() {
    }

    public BaseResponse(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public BaseResponse(Boolean success, String code, String message, String stack) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.stack = stack;
    }


    public BaseResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
