package com.pm.dao.datasource;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_manager", schema = "pm")
public class Manager {
    private int id;
    private String mgName;
    private String mgPwd;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mg_name", nullable = false, length = 255)
    public String getMgName() {
        return mgName;
    }

    public void setMgName(String mgName) {
        this.mgName = mgName;
    }

    @Basic
    @Column(name = "mg_pwd", nullable = false, length = 255)
    public String getMgPwd() {
        return mgPwd;
    }

    public void setMgPwd(String mgPwd) {
        this.mgPwd = mgPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id &&
                Objects.equals(mgName, manager.mgName) &&
                Objects.equals(mgPwd, manager.mgPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mgName, mgPwd);
    }
}
