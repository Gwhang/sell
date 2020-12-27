package com.gwh.sell.service.impl;

import com.gwh.sell.dao.ProductInfoDao;
import com.gwh.sell.dataObject.ProductInfo;
import com.gwh.sell.enums.ProductStatusEnum;
import com.gwh.sell.service.ProductInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品详情业务层
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    Logger logger= LoggerFactory.getLogger(ProductInfoServiceImpl.class);

    @Autowired
    private ProductInfoDao productInfoDao;

    /**
     * 查询单条商品信息
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findOne(String productId) {
        logger.info("[商品明细查询] 传输的参数为:{}",productId);
        return this.productInfoDao.getOne(productId);
    }

    /**
     * 查询上架商品
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return this.productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 分页查询所有商品
     * @param pageable
     * @return
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return this.productInfoDao.findAll(pageable);
    }

    /**
     * 保存 更新
     * @param productInfo
     * @return
     */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return this.productInfoDao.save(productInfo);
    }
}