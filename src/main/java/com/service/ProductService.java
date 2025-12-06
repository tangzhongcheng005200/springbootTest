package com.service;

import com.example.entity.ProductDomin;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductService {
    ProductDomin getById(Integer productId);

    List<ProductDomin> listAll();

    /**
     * 动态查询
     * @param params
     * @return
     */
    List<ProductDomin> selectByCondition(Map<String, Object> params);


    PageInfo<ProductDomin> selectByPage(int pageNum, int pageSize);
}
