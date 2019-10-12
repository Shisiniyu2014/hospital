package com.zhiyou100.model;

public class ChargeManager {
    private Integer id;

    private String medical_record;

    private Integer pay_items_id;

    private Double charge_money;

    private String charge_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getMedical_record() {
		return medical_record;
	}

	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}

	public Integer getPay_items_id() {
		return pay_items_id;
	}

	public void setPay_items_id(Integer pay_items_id) {
		this.pay_items_id = pay_items_id;
	}

	public Double getCharge_money() {
		return charge_money;
	}

	public void setCharge_money(Double charge_money) {
		this.charge_money = charge_money;
	}

	public String getCharge_time() {
		return charge_time;
	}

	public void setCharge_time(String charge_time) {
		this.charge_time = charge_time;
	}

	@Override
	public String toString() {
		return "ChargeManager [id=" + id + ", medical_record=" + medical_record + ", pay_items_id=" + pay_items_id
				+ ", charge_money=" + charge_money + ", charge_time=" + charge_time + "]";
	}

    
}