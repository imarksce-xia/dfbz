package com.xgb.enums;

public enum SessionEnum {

    /**
     *
     */
    SESSION_PIC_CODE("abe"),
    SESSION_LOGIN("sessionLogin"),
    SESSION_FORGET("sessionForget");

    private String value;

    SessionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
