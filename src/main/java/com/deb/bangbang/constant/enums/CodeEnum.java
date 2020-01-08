package com.deb.bangbang.constant.enums;

/**
 * 登录相关枚举
 */
public enum CodeEnum {
    //通用状态
    SUCCESS("success", 200),
    FAIL("fail", 201),
    UNKNOW("unknow error", 202),
    //登录相关
    INFO_NOT_COMPLETE("信息填写不完整",301),
    OPENID_NOT_FOUND("openid不存在", 302);
    private String desc;
    private int code;

    CodeEnum(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
