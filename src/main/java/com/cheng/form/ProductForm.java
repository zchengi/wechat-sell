package com.cheng.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cheng
 *         2018/5/6 15:06
 */
@Data
public class ProductForm {

    private String productId;

    /**
     * 名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 类目编号
     */
    private Integer categoryType;
}
