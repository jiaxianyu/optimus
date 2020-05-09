package lfhfirst.exception;

import lfhfirst.constant.BizCode;

@BizErrorResponseStatus(BizCode.BIZ_ERROR)
public class NotPermissionException extends RuntimeException{

    public NotPermissionException(String message) {
        super(message);
    }
}
