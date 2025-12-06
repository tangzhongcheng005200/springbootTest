package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.ProductDomin;
import com.example.entity.ProductDominTwo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/{productId}")
    public ProductDomin getById(@PathVariable Integer productId) {
        ProductDomin productDomin = service.getById(productId);
        return productDomin;
    }

    @PostMapping("/listAll")
    public List<ProductDomin> listAll() {
        return service.listAll();
    }

    /**
     * 动态查询
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/selectByCondition")
    public List<ProductDomin> selectByCondition(@RequestBody JSONObject jsonObject) throws InvocationTargetException, IllegalAccessException {
        Object productName = jsonObject.get("productName");//商品名称
        Object price = jsonObject.get("price");//价格
        Object description = jsonObject.get("description");//商品描述
        HashMap<String, Object> map = new HashMap<>();
        map.put("productName", productName);
        map.put("price", price);
        map.put("description", description);
        List<ProductDomin> productDomins = service.selectByCondition(map);

        ProductDominTwo target=new ProductDominTwo();
        ProductDomin source = productDomins.get(0);
        BeanUtils.copyProperties(target,source);
        System.out.println(target.toString());
        return productDomins;
    }

    @GetMapping("/selectByPage")
    public PageInfo<ProductDomin> selectByPage(@RequestParam(defaultValue = "1") int pageNum,
                                               @RequestParam(defaultValue = "3") int pageSize) {



        return service.selectByPage(pageNum,pageSize);
    }
}
