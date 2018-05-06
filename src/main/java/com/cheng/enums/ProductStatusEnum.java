package com.cheng.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author cheng
 *         2018/5/4 18:20
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0, "已上架"),
    DOWN(1, "已下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
