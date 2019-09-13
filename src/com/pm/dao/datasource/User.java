package com.pm.dao.datasource;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_user", schema = "pm")
public class User {
    private String id;
    private String userName;
    private String userPwd;
    private byte isFreeze;

   @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pwd", nullable = false, length = 255)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "is_freeze", nullable = false)
    public byte getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(byte isFreeze) {
        this.isFreeze = isFreeze;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                isFreeze == user.isFreeze &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPwd, user.userPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPwd, isFreeze);
    }
}
