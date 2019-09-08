package com.pm.dao.datasource;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_point", schema = "pm")
public class Point {
    private int id;
    private int pointValue;
    private Integer userId;
    private Integer ptId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "pt_id", nullable = true)
    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return id == point.id &&
                pointValue == point.pointValue &&
                Objects.equals(userId, point.userId) &&
                Objects.equals(ptId, point.ptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pointValue, userId, ptId);
    }
}
