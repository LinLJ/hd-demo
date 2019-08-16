package com.example.demo.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")//todo
@NamedQuery(name="User.findAll", query="SELECT c FROM User c")
public class User implements Serializable {
    private static final long serialVersionUID = -2731598327208972274L;

    @Id
    @Column(name="id")
    private String id;

    @Column(name="role_id")
    private String roleId;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="hd_id")
    private String hdId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHdId() {
        return hdId;
    }

    public void setHdId(String hdId) {
        this.hdId = hdId;
    }
}
