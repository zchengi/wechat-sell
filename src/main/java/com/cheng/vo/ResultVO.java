package com.cheng.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 *
 * @author cheng
 *         2018/5/4 18:42
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
