package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;

public interface DoctorService {

	int count(Map<String, Object> map);

	List<Doctor> findAll(Map<String, Object> map);

	Doctor findOne(int id);

	boolean editOne(Doctor doctor);

	int addOne(Doctor doctor);

}
