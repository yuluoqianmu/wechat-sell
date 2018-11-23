package com.maolin.bootlink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maolin.bootlink.entity.ProductInfo;
import com.maolin.bootlink.enums.ProductStatusEnum;
import com.maolin.bootlink.mapper.ProductInfoMapper;
import com.maolin.bootlink.service.IProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaomaolin
 * @since 2018-11-21
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {


    /**
     * 查询在架的商品
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {

        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ProductInfo::getProductStatus, ProductStatusEnum.UP.getCode());

        return baseMapper.selectList(wrapper);
    }
}
