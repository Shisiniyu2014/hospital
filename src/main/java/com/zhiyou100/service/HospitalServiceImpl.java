package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.HospitalMapper;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalMapper mapper;
	
	
	@Override
	public List<RegistrationInfor> findAll(Map<String, String> map) {
		
		return mapper.findAll(map);
	}


	@Override
	public int addHos(HospitalInfor hospitalInfor) {
		
		return mapper.addHos(hospitalInfor);
	}


	@Override
	public RegistrationInfor findRegHos(String id) {
		return mapper.findRegHos(id);
	}


	@Override
	public int editHos(HospitalInfor hospitalInfor) {
		
		return mapper.editHos(hospitalInfor);
	}


	@Override
	public int delReg(String id) {
		
		return mapper.delReg(id);
	}


	@Override
	public int delHos(String id) {
		return mapper.delHos(id);
	}


	@Override
	public int delRegs(String[] ids) {
		return mapper.delRegs(ids);
	}


	@Override
	public int delHoss(String[] ids) {
		return mapper.delHoss(ids);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
