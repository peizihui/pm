package com.pm.dao.datasource;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_pointtype", schema = "pm")
public class Pointtype {
    private int id;
    private String pointType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "point_type", nullable = false, length = 255)
    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pointtype pointtype = (Pointtype) o;
        return id == pointtype.id &&
                Objects.equals(pointType, pointtype.pointType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pointType);
    }
}
