package com.cheng.service.impl;

import com.cheng.dataobject.SellerInfo;
import com.cheng.repository.SellerInfoRepository;
import com.cheng.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cheng
 *         2018/5/7 10:19
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {
        return repository.findByOpenid(openid);
    }
}
