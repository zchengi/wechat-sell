package com.cheng.repository;

import com.cheng.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cheng
 *         2018/5/7 10:14
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);


}
