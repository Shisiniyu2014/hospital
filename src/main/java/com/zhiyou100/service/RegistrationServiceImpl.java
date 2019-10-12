package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.RegistrationMapper;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegistrationMapper mapper;
	
	@Override
	public List<RegistrationInfor> findAll(Map<String, Object> map) {
		
		return mapper.findAll(map);
	}

	@Override
	public RegistrationInfor findOne(String id) {
		
		return mapper.findOne(id);
	}

	@Override
	public int editOne(RegistrationInfor reg) {
		return mapper.editOne(reg);
	}

	@Override
	public int addReg(RegistrationInfor reg) {
		
		return mapper.addReg(reg);
	}

	@Override
	public int delRegs(String[] ee) {
		return mapper.delRegs(ee);
	}

	@Override
	public int delOne(String id) {
		return mapper.delOne(id);
	}

	
	
	
	
	
	
	
}
