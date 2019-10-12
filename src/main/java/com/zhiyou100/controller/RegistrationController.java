package com.zhiyou100.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.RegistrationService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@RequestMapping("/list")
	public String findAllRegistration(@RequestParam(defaultValue = "")String medical_record,
			@RequestParam(defaultValue = "")String dname,
			@RequestParam(defaultValue = "")String section,@RequestParam(defaultValue = "")String time1,
			@RequestParam(defaultValue = "")String time2,@RequestParam(defaultValue="1")int pageNo,Model model) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("medical_record", medical_record);
		map.put("dname", dname);
		map.put("section", section);
		map.put("time1", time1);
		map.put("time2", time2);
		
		PageHelper.startPage(pageNo, 2);
		
		System.out.println("findAll执行前");
		List<RegistrationInfor> registrationInfor = service.findAll(map);
		System.out.println("findAll执行后");
		PageInfo<RegistrationInfor> pageInfo = new PageInfo<>(registrationInfor);
		model.addAttribute("reg", pageInfo.getList());
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		
		return "registration/index";
	}
	
	
	@RequestMapping("/look")
	public String findOne(String id,Model model){
		RegistrationInfor reg = service.findOne(id);
		model.addAttribute("reg", reg);
		
		return "registration/look";
		
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editGet(String id,Model model){
		RegistrationInfor reg = service.findOne(id);
		model.addAttribute("reg", reg);
		
		return "registration/edit";
		
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editPost(RegistrationInfor reg,Model model){
		int rowNum = service.editOne(reg);
		if(rowNum > 0){
			return "forward:/registration/list";
		}
		model.addAttribute("msg", "更新失败请重试");
		return "registration/edit";
		
	}
	
	
	// 住院管理模块添加功能
	@RequestMapping("/hospital/add")
	public String addGetOne(String id,Model model){
		
		RegistrationInfor reg = service.findOne(id);
		model.addAttribute("reg", reg);
		
		return "hospital/add";
		
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addGet() {
		return "registration/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPost(RegistrationInfor reg,Model model){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date time =sdf.parse(sdf.format(date));
			reg.setTime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		
		int rowNum = service.addReg(reg);
		if(rowNum > 0){
			return "forward:/registration/list";
		}
		model.addAttribute("msg", "添加失败");
		return "registration/add";
	}

	
	@RequestMapping("/del")
	public String delOne(String id,Model model){
		int rowNum = service.delOne(id);
		if(rowNum > 0){
			return "forward:/registration/list";
		}
		model.addAttribute("msg", "删除失败");
		return "registration/index";
		
	}
	
	
	
	
	
	@RequestMapping("/delS")
	public String delRegs(String[] ee,Model model){
		
		int rowNum = service.delRegs(ee);
		if(rowNum > 0){
			return "forward:/registration/list";
		}
		model.addAttribute("msg", "批量删除失败,请重试");
		return "registration/index";
		
	}
	
	
	
	
	
	
	
}
