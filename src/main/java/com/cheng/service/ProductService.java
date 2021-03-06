package com.cheng.service;

import com.cheng.dataobject.ProductInfo;
import com.cheng.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 *
 * @author cheng
 *         2018/5/4 18:14
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有上架商品
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 添加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减少库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架
     */
    ProductInfo onSale(String productId);

    /**
     * 下架
     */
    ProductInfo offSale(String productId);
}
