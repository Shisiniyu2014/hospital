package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DrugMapper;
import com.zhiyou100.model.Drug;

@Service
public class DrugServiceImpl implements DrugService {
	
	@Autowired
	private DrugMapper mapper;
	
	@Override
	public List<Drug> findAll(Map<String, String> keywordmap) {
		return mapper.findAll(keywordmap);
	}

	@Override
	public Drug findOne(String id) {
		
		return mapper.findOne(id);
	}

	@Override
	public int addDrug(Drug drug) {
		
		return mapper.addDrug(drug);
	}

	@Override
	public int editDrug(Drug drug) {
		
		return mapper.editDrug(drug);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
