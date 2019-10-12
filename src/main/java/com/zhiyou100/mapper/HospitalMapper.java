package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;

public interface HospitalMapper {

	List<RegistrationInfor> findAll(Map<String, String> map);

	int addHos(HospitalInfor hospitalInfor);

	RegistrationInfor findRegHos(String id);

	int editHos(HospitalInfor hospitalInfor);

	int delReg(String id);

	int delHos(String id);

	int delRegs(String[] ids);

	int delHoss(String[] ids);

}
