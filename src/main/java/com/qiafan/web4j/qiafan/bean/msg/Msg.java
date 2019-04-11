package com.qiafan.web4j.qiafan.bean.msg;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 17:13
 */
public class Msg {
    int code;
    String message;
    String msgname;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgname() {
        return msgname;
    }

    public void setMsgname(String msgname) {
        this.msgname = msgname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", msgname='" + msgname + '\'' +
                '}';
    }
}
