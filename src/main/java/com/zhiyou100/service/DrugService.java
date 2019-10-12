package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Drug;

public interface DrugService {

	List<Drug> findAll(Map<String, String> keywordmap);

	Drug findOne(String id);

	int addDrug(Drug drug);

	int editDrug(Drug drug);

}
