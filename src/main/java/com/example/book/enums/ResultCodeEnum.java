package com.example.book.enums;

public enum ResultCodeEnum {
    UNLOGIN(-1),
    SUCCESS(200),
    FALL(-2);
    private int code;

    ResultCodeEnum(int code) {
        this.code=code;
    }
}
