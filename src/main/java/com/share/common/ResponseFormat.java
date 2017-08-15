package com.share.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by  bin
 * Time： 2017/8/15.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseFormat<T> implements Serializable{
    private int status;
    private String message;
    private T data;

    private ResponseFormat(int status){
        this.status = status;
    }
    private ResponseFormat(int status,String message){
        this.status = status;
        this.message = message;
    }
    private ResponseFormat(int status,String message,T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
    private ResponseFormat(int status,T data){
        this.status = status;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }
    public String getMessage(){
        return message;
    }
    public T getData(){
        return data;
    }

    public static <T> ResponseFormat<T> createBySuccess(){
        return new ResponseFormat<T>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ResponseFormat<T> createBySuccessMessage(String message){
        return new ResponseFormat<T>(ResponseCode.SUCCESS.getCode(),message);
    }
    public static <T> ResponseFormat<T> createBySuccess(T data){
        return new ResponseFormat<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ResponseFormat<T> createBySuccess(String message, T data){
        return new ResponseFormat<T>(ResponseCode.SUCCESS.getCode(),message,data);
    }
    public static <T> ResponseFormat<T> createByError(){
        return new ResponseFormat<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ResponseFormat<T> createByErrorMessage(String errorMessage){
        return new ResponseFormat<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }
    public static <T> ResponseFormat<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new ResponseFormat<T>(errorCode,errorMessage);
    }
}
