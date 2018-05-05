package com.cheng.repository;

import com.cheng.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cheng
 *         2018/5/5 12:00
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {


    /**
     * 根据买家 openid 查询订单列表
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
