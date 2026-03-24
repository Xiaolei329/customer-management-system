/**
 * @Title NewSSMBOOT
 * @Package com.vo
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.vo;

import lombok.Data;

//封装返回对象
public class ResultObject<T> {
    private int code;
    private String msg;
    private T data;
    private Long count;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}
