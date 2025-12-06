package com.service.impl;

import com.example.entity.ProductDomin;
import com.example.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public ProductDomin getById(Integer productId) {
        ProductDomin byId = productMapper.getById(productId);
        return byId;
        //userService.selectUser(productId);
        //return new ProductDomin();
    }

    @Override
    public List<ProductDomin> listAll() {
        return productMapper.listAll();
    }

    @Override
    public List<ProductDomin> selectByCondition(Map<String, Object> params) {
        return productMapper.selectByCondition(params);
    }

    @Override
    public PageInfo<ProductDomin> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductDomin> productDomins = productMapper.listAll();
        return new PageInfo<>(productDomins);
    }


}
