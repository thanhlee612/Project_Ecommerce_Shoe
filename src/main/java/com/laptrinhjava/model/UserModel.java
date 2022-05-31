package com.laptrinhjava.model;

public class UserModel extends AbstractModel<UserModel>{
 
    private String username;
    private String fullname;
    private String password;
    private int status;
	 private Integer roleId; 
    private roleModel role = new roleModel();


    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public roleModel getRole() {
        return role;
    }

    public void setRole(roleModel role) {
        this.role = role;
    }

}
