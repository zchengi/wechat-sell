package com.cheng.enums;

import lombok.Getter;

/**
 * 订单支付状态
 *
 * @author cheng
 *         2018/5/5 11:52
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
