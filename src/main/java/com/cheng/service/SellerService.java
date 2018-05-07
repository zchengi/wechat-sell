package com.cheng.service;

import com.cheng.dataobject.SellerInfo;

/**
 * 卖家端
 * @author cheng
 *         2018/5/7 10:18
 */
public interface SellerService {

    /**
     * 通过 openid 直接查询用户信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenId(String openid);
}
