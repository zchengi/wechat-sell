package com.cheng.exception;

import com.cheng.enums.ResultEnum;
import lombok.Getter;

/**
 * @author cheng
 *         2018/5/5 12:43
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {

        super(message);
        this.code = code;
    }
}
