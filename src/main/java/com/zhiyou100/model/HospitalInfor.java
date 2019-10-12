package com.zhiyou100.model;

public class HospitalInfor {
    private String medical_record;

    private String caregiver;

    private String bed_id;

    private Double pay_the_deposit;

    private String state_illness;

	public String getMedical_record() {
		return medical_record;
	}

	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}

	public String getCaregiver() {
		return caregiver;
	}

	public void setCaregiver(String caregiver) {
		this.caregiver = caregiver;
	}

	public String getBed_id() {
		return bed_id;
	}

	public void setBed_id(String bed_id) {
		this.bed_id = bed_id;
	}

	public Double getPay_the_deposit() {
		return pay_the_deposit;
	}

	public void setPay_the_deposit(Double pay_the_deposit) {
		this.pay_the_deposit = pay_the_deposit;
	}

	public String getState_illness() {
		return state_illness;
	}

	public void setState_illness(String state_illness) {
		this.state_illness = state_illness;
	}

	@Override
	public String toString() {
		return "HospitalInfor [medical_record=" + medical_record + ", caregiver=" + caregiver + ", bed_id=" + bed_id
				+ ", pay_the_deposit=" + pay_the_deposit + ", state_illness=" + state_illness + "]";
	}

    
}