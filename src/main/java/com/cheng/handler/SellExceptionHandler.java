package com.cheng.handler;

import com.cheng.exception.ResponseBankException;
import com.cheng.exception.SellException;
import com.cheng.utils.ResultVOUtil;
import com.cheng.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author cheng
 *         2018/5/7 10:43
 */
@ControllerAdvice
public class SellExceptionHandler {

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankExceptionException() {
    }
}
