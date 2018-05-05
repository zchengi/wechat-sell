package com.cheng.service;

import com.cheng.dto.OrderDTO;

/**
 * 买家
 *
 * @author cheng
 *         2018/5/5 16:49
 */
public interface BuyerService {

    /**
     * 查询一个订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
