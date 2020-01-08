package com.deb.bangbang.bean.result;

public class JsonResult {
    private Integer status;
    private Object data;

    public JsonResult(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
