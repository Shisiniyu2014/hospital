package com.zhiyou100.model;

import java.util.Date;

public class Doctor {
    private Integer id;

    private String name;

    private Integer certificate_type;

    private String ID_num;

    private String phone;

    private String special_plane;

    private Integer sex;

    private Integer age;

    private String birther;

    private String email;

    private Integer section_id;

    private Integer education;

    private String noted;

    private Date time;
    
    
    private Section section;
    
    private CertificateType certificateType;
    
    
    
    

    public CertificateType getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(CertificateType certificateType) {
		this.certificateType = certificateType;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public Integer getCertificate_type() {
		return certificate_type;
	}

	public void setCertificate_type(Integer certificate_type) {
		this.certificate_type = certificate_type;
	}

	public String getID_num() {
		return ID_num;
	}

	public void setID_num(String iD_num) {
		ID_num = iD_num;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSpecial_plane() {
		return special_plane;
	}

	public void setSpecial_plane(String special_plane) {
		this.special_plane = special_plane;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirther() {
		return birther;
	}

	public void setBirther(String birther) {
		this.birther = birther;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSection_id() {
		return section_id;
	}

	public void setSection_id(Integer section_id) {
		this.section_id = section_id;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getNoted() {
		return noted;
	}

	public void setNoted(String noted) {
		this.noted = noted;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", certificate_type=" + certificate_type + ", ID_num=" + ID_num
				+ ", phone=" + phone + ", special_plane=" + special_plane + ", sex=" + sex + ", age=" + age
				+ ", birther=" + birther + ", email=" + email + ", section_id=" + section_id + ", education="
				+ education + ", noted=" + noted + ", time=" + time + ", section=" + section + ", certificateType="
				+ certificateType + "]";
	}



    
}