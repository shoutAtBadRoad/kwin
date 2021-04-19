package com.kwin.db.config.response;

public enum ResultStatusEnum {

    /**
     * | 200      | OK                    | 请求成功
     * | 201      | CREATED               | 创建成功
     * | 204      | DELETED               | 删除成功
     * | 400      | BAD REQUEST           | 请求的地址不存在或者包含不支持的参数
     * | 401      | UNAUTHORIZED          | 未授权
     * | 403      | FORBIDDEN             | 被禁止访问
     * | 404      | NOT FOUND             | 请求的资源不存在
     * | 422      | Unprocesable entity   | [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误
     * | 500      | INTERNAL SERVER ERROR | 内部错误
     */
    SUCCESS(1, "成功"), //public static final
    OK(200,"请求成功"),
    CREATED(201,"创建成功"),
    DELETED(204,"删除成功"),
    BADREQUEST(400,"请求的地址不存在或者不支持的参数"),
    UNAUTHORIZED(401,"未授权"),
    FORBIDDEN(403,"被禁止的访问"),
    NOTFOUND(404,"请求的资源不存在"),
    ERROR(-1, "错误"),
    NOT_FOUND(-404, "没有找到"),
    NOT_EMPTY(-200, "字段不能为空"),
    DUPLICATE_EXCEPTION(-3, "重复异常"),

    /**
     * 规约：时间异常类 value定义区间为 -100 ~ -199
     */
    TIME_EMPTY(-100, "时间不能为空"),
    TIME_MORE_THAN_14_DAYS(-101, "时间跨度不能超过两个星期"),

    /**
     * 规约：字段为空 value区间 -200 ~ -299
     */
    OPENID_EMPTY(-201, "openid不能为空");
    private int value;

    private String msg;

    ResultStatusEnum(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

}
