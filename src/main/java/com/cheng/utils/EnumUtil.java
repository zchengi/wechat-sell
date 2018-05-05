package com.cheng.utils;

import com.cheng.enums.CodeEnum;

/**
 * @author cheng
 *         2018/5/5 18:35
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
