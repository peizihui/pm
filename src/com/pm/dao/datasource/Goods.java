package com.pm.dao.datasource;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_goods", schema = "pm")
public class Goods {
    private int id;
    private String goodsId;
    private String goodsName;
    private int goodsPrice;
    private byte isDele;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goods_id", nullable = false, length = 255)
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_name", nullable = false, length = 255)
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_price", nullable = false)
    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Basic
    @Column(name = "is_dele", nullable = false)
    public byte getIsDele() {
        return isDele;
    }

    public void setIsDele(byte isDele) {
        this.isDele = isDele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return id == goods.id &&
                goodsPrice == goods.goodsPrice &&
                Objects.equals(goodsId, goods.goodsId) &&
                Objects.equals(goodsName, goods.goodsName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goodsId, goodsName, goodsPrice);
    }
}
