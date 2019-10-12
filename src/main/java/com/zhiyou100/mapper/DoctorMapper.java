package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;

public interface DoctorMapper {

	int count(Map<String, Object> map);

	List<Doctor> findAll(Map<String, Object> map);

	Doctor findOne(int id);

	int editOne(Doctor doctor);

	int addOne(Doctor doctor);

}
