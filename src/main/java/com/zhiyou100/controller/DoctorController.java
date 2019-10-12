package com.zhiyou100.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Doctor;

import com.zhiyou100.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "")String id,@RequestParam(defaultValue = "")String name,
			@RequestParam(defaultValue = "")String secco_name,@RequestParam(defaultValue="1")int pageNo,Model model) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("secco_name", secco_name);
		
//		int total = service.count(map);
		
		PageHelper.startPage(pageNo, 2);
		
		
		// 登录成功,展现全部用户
		List<Doctor> doctors = service.findAll(map);
		PageInfo<Doctor> pageInfo = new PageInfo<>(doctors);
		System.out.println("登录成功查询的全部用户 : " + doctors);
		System.out.println(pageInfo.getList());
		model.addAttribute("doctors", pageInfo.getList());
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		
		
		return "doctor/index";
		
	}
	
	@RequestMapping("/look")
	public String findOne(int id,Model model){
		
		Doctor doctor = service.findOne(id);
		
		model.addAttribute("doctor", doctor);
		
		return "doctor/look";
		
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findEditOne(int id,Model model){
		Doctor doctor = service.findOne(id);
		model.addAttribute("doctor", doctor);
		return "doctor/edit";
		
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editOne(Doctor doctor,Model model){
		
		boolean result = service.editOne(doctor);
		if(result){
			return "forward:/doctor/list";
		}
		model.addAttribute("msg", "更新失败请重试");
		return "doctor/edit";
		
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addUI(){
		return "doctor/add";
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addOne(Doctor doctor,Model model){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date time =sdf.parse(sdf.format(date));
			doctor.setTime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		int rowNum = service.addOne(doctor);
		if(rowNum > 0){
			return "forward:/doctor/list";
		}
		model.addAttribute("msg", "添加失败请重试");
		return "doctor/add";
		
	}
	
	

	
	
	
	
	
	
	
}
