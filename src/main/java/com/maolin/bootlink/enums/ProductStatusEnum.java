package com.maolin.bootlink.enums;

import lombok.Getter;

/**
 * Created by shaomaolin on 2018/11/22.
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
