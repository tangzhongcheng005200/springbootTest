package com.example.entity;

import lombok.Data;

/*
商品数据
 */
@Data
public class ProductDominTwo {
    public int product_id;//'商品ID',
    public String product_name;//'商品名称',
    public String category_id; //'所属分类ID',
    public String price; //'售价',
    public String stock;// '库存',
    public String sales; //'销量',
    public String cover_img;//'封面图片URL',
    public String description;//'商品描述',
    public String status;// '状态：0-下架，1-上架',

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ProductDomin{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", category_id='" + category_id + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", sales='" + sales + '\'' +
                ", cover_img='" + cover_img + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
