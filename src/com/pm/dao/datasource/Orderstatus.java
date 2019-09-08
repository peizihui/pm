package com.pm.dao.datasource;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_orderstatus", schema = "pm")
public class Orderstatus {
    private int id;
    private String osType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "os_type", nullable = false, length = 255)
    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderstatus that = (Orderstatus) o;
        return id == that.id &&
                Objects.equals(osType, that.osType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, osType);
    }
}
