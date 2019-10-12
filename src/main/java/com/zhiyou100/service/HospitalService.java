package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;

public interface HospitalService {

	List<RegistrationInfor> findAll(Map<String, String> map);

	int addHos(HospitalInfor hospitalInfor);

	RegistrationInfor findRegHos(String id);

	int editHos(HospitalInfor hospitalInfor);

	// 删除需要删除两个表中的数据所以写两个方法
	// 单个1
	int delReg(String id);

	// 单个2
	int delHos(String id);
	
	// 批量1
	int delRegs(String[] ids);

	// 批量2
	int delHoss(String[] ids);

	

}
