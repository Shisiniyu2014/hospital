package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.ChargeMapper;
import com.zhiyou100.model.PayItems;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class ChargeServiceImpl implements ChargeService {
	
	@Autowired
	private ChargeMapper mapper;
	
	@Override
	public List<RegistrationInfor> findAll(Map<String, String> map) {
		return mapper.findAll(map);
	}

	@Override
	public RegistrationInfor findOne(String id) {
		return mapper.findOne(id);
	}

	@Override
	public PayItems findPayOne(String charge_item_name) {
		return mapper.findPayOne(charge_item_name);
	}

	@Override
	public int addOne(Map<String, Object> map) {
		return mapper.addOne(map);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
