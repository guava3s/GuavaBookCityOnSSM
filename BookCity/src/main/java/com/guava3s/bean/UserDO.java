package com.guava3s.bean;

import com.guava3s.common.Const;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author micolen
 * @version 1.0
 * @ClassName User
 * @date 2021/11/16 19:11
 */
public class UserDO implements Serializable {

    private static final long serialVersionUID = 2021111717150001L;
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String state;
    private String permission;
    private String usable;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDO userDO = (UserDO) o;
        return Objects.equals(id, userDO.id) &&
                Objects.equals(username, userDO.username) &&
                Objects.equals(password, userDO.password) &&
                Objects.equals(email, userDO.email) &&
                Objects.equals(state, userDO.state) &&
                Objects.equals(permission, userDO.permission) &&
                Objects.equals(usable, userDO.usable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, state, permission, usable);
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", permission='" + permission + '\'' +
                ", usable='" + usable + '\'' +
                '}';
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        if (Const.NUMBER_0.equals(usable)) {
            this.usable = usable;
        } else {
            this.usable = "1";
        }
    }

    public UserDO(Integer id, String username, String password, String email, String state, String permission, String usable) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
        this.permission = permission;
        if (Const.NUMBER_0.equals(usable)) {
            this.usable = usable;
        } else {
            this.usable = "1";
        }
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public UserDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UserDO(Integer id, String username, String password, String email, String state, String permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
        this.permission = permission;
    }
}
