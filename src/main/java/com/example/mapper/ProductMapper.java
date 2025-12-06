package com.example.mapper;

import com.example.entity.ProductDomin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 商品表 增删改查
 */
public interface ProductMapper {
    ProductDomin getById(@Param("productId")Integer productId);

    List<ProductDomin> listAll();

    /**
     * 动态查询
     * @param params
     * @return
     */
    List<ProductDomin> selectByCondition(@Param("params") Map<String, Object> params);
}
