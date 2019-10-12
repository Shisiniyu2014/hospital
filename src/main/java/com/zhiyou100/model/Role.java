package com.zhiyou100.model;

public class Role {
    private Integer id;

    private String role_num;

    private String role_name;

    private Integer statuss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getRole_num() {
		return role_num;
	}

	public void setRole_num(String role_num) {
		this.role_num = role_num;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Integer getStatuss() {
        return statuss;
    }

    public void setStatuss(Integer statuss) {
        this.statuss = statuss;
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", role_num=" + role_num + ", role_name=" + role_name + ", statuss=" + statuss + "]";
	}
    
    
}