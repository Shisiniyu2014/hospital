package com.zhiyou100.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.zhiyou100.model.PayItems;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.ChargeService;

@Controller
@RequestMapping("/charge")
public class ChargeController {
	
	@Autowired
	private ChargeService service;
	
	@RequestMapping("/list")
	public String list(@RequestParam Map<String,String> map,
			@RequestParam(defaultValue="1") int pageNo,Model model){
		
		PageHelper.startPage(pageNo, 2);
		
		List<RegistrationInfor> registrationInfor = service.findAll(map);
		
		PageInfo<RegistrationInfor> pageInfo = new PageInfo<>(registrationInfor);
		model.addAttribute("regs",pageInfo.getList());
		model.addAttribute("map",map);
		model.addAttribute("page",pageInfo);
		
		return "charge/index";
		
		
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addGet(@RequestParam(defaultValue="") String id,@RequestParam(defaultValue="") String charge_item_name,Model model){
		RegistrationInfor reg = service.findOne(id);
		model.addAttribute("reg", reg);
		/*
		 * 在查询reg的方法中引入查询pay的方法,接收对应字段,默认值设置为空,同时页面添加用于提交对应字段的隐藏输入框
		 */
		PayItems pay = service.findPayOne(charge_item_name);
		model.addAttribute("pay", pay);
		
		return "charge/add";
		
	}
	
//	由于上面的方法中已经进行了两者的查询,两个方法重复
//	@RequestMapping("/adds")
//	public String add1Get(@RequestParam(defaultValue="") String id,String charge_item_name,Model model){
//		PayItems pay = service.findPayOne(charge_item_name);
//		model.addAttribute("pay", pay);
//		/*
//		 * 在查询pay的方法中引入查询reg的方法,接收对应字段,默认值设置为空,同时页面添加用于提交对应字段的隐藏输入框
//		 */
//		RegistrationInfor reg = service.findOne(id);
//		model.addAttribute("reg", reg);
//		
//		return "charge/add";
//		
//	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPost(@RequestParam Map<String,Object> map,Model model){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date time =sdf.parse(sdf.format(date));
			map.put("time", time);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		int rowNum = service.addOne(map);
		if(rowNum > 0){
			return "forward:/charge/list";
		}
		model.addAttribute("msg", "添加失败请重试");
		return "charge/add";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
