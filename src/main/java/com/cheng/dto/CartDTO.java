package com.cheng.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author cheng
 *         2018/5/5 13:07
 */
@Data
public class CartDTO {

    /**
     * 商品 id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
