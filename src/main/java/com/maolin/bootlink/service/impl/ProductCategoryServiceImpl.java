package com.maolin.bootlink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maolin.bootlink.entity.ProductCategory;
import com.maolin.bootlink.mapper.ProductCategoryMapper;
import com.maolin.bootlink.service.IProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements IProductCategoryService {


    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {

        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(ProductCategory::getCategoryType, categoryTypeList);
        return baseMapper.selectList(wrapper);
    }
}
