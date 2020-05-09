package lfhfirst.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author DEEPEXI
 */

public class ResultEnums<T> {

    private String code;
    private String msg;

    ResultEnums(String code,String msg){
        this.code=code;
        this.msg=msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResultEnums  SUCCESS(){
        return new ResultEnums("200","success");
    }
    public static ResultEnums FAIL(){
        return new ResultEnums("400","系统异常请重试");
    }

    public  ResultEnums<T> FAIL_MSG(String code,String msg){
        return new ResultEnums(code,msg);
    }
}
