package com.cheng.form;

import lombok.Data;

/**
 * @author cheng
 *         2018/5/6 15:51
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;
}
