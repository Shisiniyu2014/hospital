package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.RegistrationInfor;

public interface RegistrationService {

	List<RegistrationInfor> findAll(Map<String, Object> map);

	RegistrationInfor findOne(String id);

	int editOne(RegistrationInfor reg);

	int addReg(RegistrationInfor reg);

	int delRegs(String[] ee);

	int delOne(String id);

	

}
