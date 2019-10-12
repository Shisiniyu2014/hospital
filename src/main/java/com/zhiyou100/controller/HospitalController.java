package com.zhiyou100.controller;

import java.util.Arrays;
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
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@RequestMapping("/list")
	public String list(@RequestParam Map<String,String> map,
			@RequestParam(defaultValue="1")int pageNo,Model model){
		
		PageHelper.startPage(pageNo, 2);
		
		
		List<RegistrationInfor> registrationInfor = service.findAll(map);
		
		PageInfo<RegistrationInfor> pageInfo = new PageInfo<>(registrationInfor);
		model.addAttribute("reg", pageInfo.getList());
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		
		return "hospital/index";
		
	}
	
	// 页面和挂号信息look页面完全相同,直接转发到挂号信息Controller的look路径,在registration/look.jsp中
	// 添加一个返回列表的标签指定返回到hospital的list页面
	@RequestMapping("/look")
	public String look(){
		return "forward:/registration/look";
		
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addGet(){
		return "hospital/add";
	}
	
	@RequestMapping("/adds")
	public String addsOne(String id,Model model){
		
		RegistrationInfor reg = service.findRegHos(id);
		System.err.println("reg是个啥球东西"+reg);
		// 两表联查,当医护表的病历号为null时,查不到数据,返回的reg为null
		if(reg != null && reg.getHospitalInfor().getMedical_record() != null && reg.getHospitalInfor().getMedical_record() != ""){
			model.addAttribute("reg", reg);
			model.addAttribute("msgs", "病人已办理过住院,请修改");
			return "hospital/edit";
		}
		
		// 当reg为null时,把id放进model域中,并请求转发到挂号信息的Controller中,因为页面需要输入病历号回显挂号信息,
		// 在挂号信息Controller中更方便,这种方法要在页面样式前加绝对路径,否则样式丢失
		
		model.addAttribute("id", id);
		return "forward:/registration/hospital/add";
		
	}
	
	
	
	
	
	
	@RequestMapping(value=("/add"),method=RequestMethod.POST)
	public String addPost(HospitalInfor hospitalInfor,Model model){
		int rowNum = service.addHos(hospitalInfor);
		if(rowNum > 0){
			return "forward:/hospital/list";
		}
		model.addAttribute("msg", "添加失败请重试");
		return "hospital/add";
		
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editGet(String id,Model model){
		RegistrationInfor reg = service.findRegHos(id);
		model.addAttribute("reg", reg);
		return "hospital/edit";
		
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editPost(HospitalInfor hospitalInfor,Model model){
		int rowNum = service.editHos(hospitalInfor);
		if(rowNum > 0){
			return "forward:/hospital/list";
		}
		model.addAttribute("msg", "更新失败请重试");
		return "hospital/edit";
		
	}
	
	@RequestMapping("/del")
	public String delOne(String id,Model model){
		int rowNum = service.delReg(id);
		int rowNum1 = service.delHos(id);
		if(rowNum > 0 && rowNum1 > 0){
			return "forward:/hospital/list";
		}
		model.addAttribute("msg", "删除失败请重试");
		return "hospital/index";
		
		
	}
	
	@RequestMapping("/dels")
	public String delsOne(String[] ids,Model model){
		System.out.println("数组"+Arrays.toString(ids));
		int rowNum = service.delRegs(ids);
		int rowNum1 = service.delHoss(ids);
		if(rowNum > 0 && rowNum1 > 0){
			return "forward:/hospital/list";
		}
		model.addAttribute("msg", "删除失败请重试");
		return "hospital/index";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
