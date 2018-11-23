package com.maolin.bootlink.controller;

import com.maolin.bootlink.VO.ProductInfoVO;
import com.maolin.bootlink.VO.ProductVO;
import com.maolin.bootlink.VO.ResultVO;
import com.maolin.bootlink.entity.ProductCategory;
import com.maolin.bootlink.entity.ProductInfo;
import com.maolin.bootlink.service.IProductCategoryService;
import com.maolin.bootlink.service.IProductInfoService;
import com.maolin.bootlink.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shaomaolin on 2018/11/21.
 */
@Api(tags = {"买家商品controller"})
@RestController
@RequestMapping("/sell/buyer/product")
public class BuyerProductController {

    @Autowired
    private IProductInfoService productInfoService;

    @Autowired
    private IProductCategoryService categoryService;

    @ApiOperation("查询商品列表")
    @GetMapping("/list")
    public ResultVO list() {

        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());

        //2.查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.拼装数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(category.getCategoryType());
            productVO.setCategoryName(category.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
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
