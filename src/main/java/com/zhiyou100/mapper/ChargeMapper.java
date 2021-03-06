package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.PayItems;
import com.zhiyou100.model.RegistrationInfor;

public interface ChargeMapper {

	List<RegistrationInfor> findAll(Map<String, String> map);

	RegistrationInfor findOne(String id);

	PayItems findPayOne(String charge_item_name);

	int addOne(Map<String, Object> map);

}
