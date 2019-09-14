package com.pm.dao.datasource;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "v_orderinf", schema = "pm", catalog = "")
public class VOrderinf {
    private String userName;
    private byte isFreeze;
    private String goodsName;
    private int goodsPrice;
    private String osType;
    private int pointValue;
    private String orderId;
    private String pointType;
    private Date createDate;
    private Date compDate;
    private int userId;
    private int oId;
    private int gId;
    private String goodsId;
    private int osId;
    private int pointId;
    private int ptId;
    private Byte isDele;

    @Basic
    @Column(name = "user_name", nullable = false, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "is_freeze", nullable = false)
    public byte getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(byte isFreeze) {
        this.isFreeze = isFreeze;
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
    @Column(name = "os_type", nullable = false, length = 255)
    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    @Basic
    @Column(name = "point_value", nullable = false)
    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    @Basic
    @Column(name = "order_id", nullable = false, length = 255)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "point_type", nullable = false, length = 255)
    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "comp_date", nullable = true)
    public Date getCompDate() {
        return compDate;
    }

    public void setCompDate(Date compDate) {
        this.compDate = compDate;
    }

    @Basic
    @Column(name = "user_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "o_ID", nullable = false)
    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    @Basic
    @Column(name = "g_ID", nullable = false)
    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    @Basic
    @Column(name = "goods_ID", nullable = false, length = 255)
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "os_ID", nullable = false)
    public int getOsId() {
        return osId;
    }

    public void setOsId(int osId) {
        this.osId = osId;
    }

    @Basic
    @Column(name = "point_ID", nullable = false)
    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    @Basic
    @Column(name = "pt_ID", nullable = false)
    public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
    }

    @Basic
    @Column(name = "is_dele", nullable = true)
    public Byte getIsDele() {
        return isDele;
    }

    public void setIsDele(Byte isDele) {
        this.isDele = isDele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VOrderinf vOrderinf = (VOrderinf) o;
        return isFreeze == vOrderinf.isFreeze &&
                goodsPrice == vOrderinf.goodsPrice &&
                pointValue == vOrderinf.pointValue &&
                userId == vOrderinf.userId &&
                oId == vOrderinf.oId &&
                gId == vOrderinf.gId &&
                osId == vOrderinf.osId &&
                pointId == vOrderinf.pointId &&
                ptId == vOrderinf.ptId &&
                Objects.equals(userName, vOrderinf.userName) &&
                Objects.equals(goodsName, vOrderinf.goodsName) &&
                Objects.equals(osType, vOrderinf.osType) &&
                Objects.equals(orderId, vOrderinf.orderId) &&
                Objects.equals(pointType, vOrderinf.pointType) &&
                Objects.equals(createDate, vOrderinf.createDate) &&
                Objects.equals(compDate, vOrderinf.compDate) &&
                Objects.equals(goodsId, vOrderinf.goodsId) &&
                Objects.equals(isDele, vOrderinf.isDele);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, isFreeze, goodsName, goodsPrice, osType, pointValue, orderId, pointType, createDate, compDate, userId, oId, gId, goodsId, osId, pointId, ptId, isDele);
    }
}
