package com.kwin.db.config.response;

import lombok.Data;

//Data注解可以不用写get，set以及tostring方法
@Data
public class ResponseResult<T> {

    private Integer status; //状态码
    private String msg; //状态信息
    private T data; //返回数据

    //设计自己需要的static方法，封装合适的ResponseResult样式
    public static <T> ResponseResult<T> build(T data) {
        return new ResponseResult<>(data);
    }

    public static <T> ResponseResult<T> build(ResultStatusEnum resultStatusEnum) {
        return new ResponseResult<>(resultStatusEnum);
    }

    public static <T> ResponseResult<T> build(Integer status, String msg, T data) {
        return new ResponseResult<>(status, msg, data);
    }

    public static <T> ResponseResult<T> build(ResultStatusEnum resultStatusEnum, String msg, T data) {
        return new ResponseResult<>(resultStatusEnum, msg, data);
    }

    public static <T> ResponseResult<T> buildError(ResultStatusEnum resultStatusEnum) {
        return new ResponseResult<>(resultStatusEnum);
    }

    public static <T> ResponseResult<T> buildClient(T data) {
        return new ResponseResult<>(data);
    }

    public static <T> ResponseResult<T> buildServer(String msg, T data) {
        return new ResponseResult<>(msg,data);
    }


    /**
     * 有错误的情况下需要传递错误码 + 错误提示
     *
     * @param status
     * @param msg
     */
    //设计合适的构造函数，提供给上面的静态方法使用
    private ResponseResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseResult(ResultStatusEnum resultStatusEnum, String msg) {
        this.status = resultStatusEnum.getValue();
        this.msg = msg;
    }

    private ResponseResult(ResultStatusEnum resultStatusEnum) {
        this.status = resultStatusEnum.getValue();
        this.msg = resultStatusEnum.getMsg();
    }


    private ResponseResult(T data) {
        if(data!=null) {
            this.status = ResultStatusEnum.OK.getValue();
            this.msg = ResultStatusEnum.OK.getMsg();
            this.data = data;
        }else {
            this.status = ResultStatusEnum.NOTFOUND.getValue();
            this.msg = ResultStatusEnum.NOTFOUND.getMsg();
            this.data = null;
        }
    }

    private ResponseResult(String msg, T data) {
        this.status = ResultStatusEnum.OK.getValue();
        this.msg = msg;
        this.data = data;
    }

    private ResponseResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ResponseResult(ResultStatusEnum resultStatusEnum, String msg, T data) {
        this.status = resultStatusEnum.getValue();
        this.msg = msg;
        this.data = data;
    }

    private ResponseResult() {}

}
