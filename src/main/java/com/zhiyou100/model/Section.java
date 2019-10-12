package com.zhiyou100.model;

public class Section {
    private Integer id;

    private String seccp_num;

    private String secco_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getSeccp_num() {
		return seccp_num;
	}

	public void setSeccp_num(String seccp_num) {
		this.seccp_num = seccp_num;
	}

	public String getSecco_name() {
		return secco_name;
	}

	public void setSecco_name(String secco_name) {
		this.secco_name = secco_name;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", seccp_num=" + seccp_num + ", secco_name=" + secco_name + "]";
	}

    
}