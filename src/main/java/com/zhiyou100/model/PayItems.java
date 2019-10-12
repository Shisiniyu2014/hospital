package com.zhiyou100.model;

public class PayItems {
    private Integer id;

    private String charge_item_name;

    private Double receivable_money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getCharge_item_name() {
		return charge_item_name;
	}

	public void setCharge_item_name(String charge_item_name) {
		this.charge_item_name = charge_item_name;
	}

	public Double getReceivable_money() {
		return receivable_money;
	}

	public void setReceivable_money(Double receivable_money) {
		this.receivable_money = receivable_money;
	}

	@Override
	public String toString() {
		return "PayItems [id=" + id + ", charge_item_name=" + charge_item_name + ", receivable_money="
				+ receivable_money + "]";
	}

   
}