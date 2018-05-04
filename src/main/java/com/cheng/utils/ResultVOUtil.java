package com.cheng.utils;

import com.cheng.vo.ResultVO;

/**
 * @author cheng
 *         2018/5/4 19:42
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {

        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code,String msg) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
