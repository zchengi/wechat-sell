package com.cheng.controller;

import com.cheng.dataobject.ProductCategory;
import com.cheng.dataobject.ProductInfo;
import com.cheng.service.CategoryService;
import com.cheng.service.ProductService;
import com.cheng.utils.ResultVOUtil;
import com.cheng.vo.ProductInfoVO;
import com.cheng.vo.ProductVO;
import com.cheng.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 *
 * @author cheng
 *         2018/5/4 18:38
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        // 1. 查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2. 查询类目(一次性查询)
        // 传统方法
        /*List<Integer> categoryType = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryType.add(productInfo.getCategoryType());
        }*/

        // 精简方法(java8, lambda)
        List<Integer> categoryType = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryType);

        // 3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(productCategory,productVO);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
