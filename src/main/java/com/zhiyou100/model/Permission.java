package com.zhiyou100.model;

public class Permission {
    private Integer id;

    private String resource_name;

    private String resource_url;

    private Integer super_resource_id;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getResource_name() {
		return resource_name;
	}

	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}

	public String getResource_url() {
		return resource_url;
	}

	public void setResource_url(String resource_url) {
		this.resource_url = resource_url;
	}

	public Integer getSuper_resource_id() {
		return super_resource_id;
	}

	public void setSuper_resource_id(Integer super_resource_id) {
		this.super_resource_id = super_resource_id;
	}

	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Permission [id=" + id + ", resource_name=" + resource_name + ", resource_url=" + resource_url
				+ ", super_resource_id=" + super_resource_id + ", status=" + status + "]";
	}
    
}