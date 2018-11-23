package com.maolin.bootlink.service;

import com.maolin.bootlink.entity.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shaomaolin
 * @since 2018-11-21
 */
public interface IProductInfoService extends IService<ProductInfo> {

    List<ProductInfo> findUpAll();

}
