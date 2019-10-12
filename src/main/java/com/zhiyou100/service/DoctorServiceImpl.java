package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DoctorMapper;
import com.zhiyou100.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorMapper mapper;
	
	@Override
	public int count(Map<String, Object> map) {
		return mapper.count(map);
	}

	@Override
	public List<Doctor> findAll(Map<String, Object> map) {
		
		return mapper.findAll(map);
	}

	@Override
	public Doctor findOne(int id) {
		
		return mapper.findOne(id);
	}

	@Override
	public boolean editOne(Doctor doctor) {
		int rowNum = mapper.editOne(doctor);
		if(rowNum > 0){
			return true;
		}
		return false;
	}

	@Override
	public int addOne(Doctor doctor) {
		
		
		
		return mapper.addOne(doctor);
	}

	
	
	
	
	
	
	
	
	
	
}
