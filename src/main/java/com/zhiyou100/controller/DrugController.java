package com.zhiyou100.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Drug;
import com.zhiyou100.service.DrugService;

@Controller
@RequestMapping("/drug")
public class DrugController {
	
	@Autowired
	private DrugService service;
	
	@RequestMapping("/list")
	public String findAll(@RequestParam Map<String,String> keywordmap,
			@RequestParam(defaultValue="1") int pageNo,Model model){
		
		PageHelper.startPage(pageNo, 2);
		
		List<Drug> drugs = service.findAll(keywordmap);
		
		PageInfo<Drug> pageInfo = new PageInfo<>(drugs);
		model.addAttribute("drugs", pageInfo.getList());
		model.addAttribute("map", keywordmap);
		model.addAttribute("page", pageInfo);
		return "drug/index";
		
		
		
	}
	
	@RequestMapping("/look")
	public String look(String id,Model model){
		Drug drug = service.findOne(id);
		model.addAttribute("drug", drug);
		return "drug/look";
		
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addGet(){
		return "drug/add";
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPost(@RequestParam("img") MultipartFile img, HttpServletRequest request,Drug drug,Model model) throws IOException{
		
		// 1.获得上传的对象
		
		// 2.获得最终上传的目的地路径(上传至服务器中当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("上传"+realPath);
		System.out.println("接收对象"+drug);
		// 2.1 将最终的目的文件夹创建出来
		File file = new File(realPath);
		// 判断该文件是否存在
		if(file.exists()){
			// 不存在则创建出
			file.mkdir();
		}
		// 2.2 获得文件名
		// 文件名重复时不能重复上传文件
		String fileName = img.getOriginalFilename();
		
		// 把文件名封装进对象
		drug.setDrug_url(fileName);
		
		System.out.println("文件名"+fileName);
		// 2.3 确定上传路径
		File newFile = new File(file,fileName);
		
		// 3.上传
		FileUtils.writeByteArrayToFile(newFile, img.getBytes());

		
		int rowNum = service.addDrug(drug);
		if(rowNum > 0){
			return "forward:/drug/list";
		}
		
		model.addAttribute("msg", "添加失败请重试");
		return "drug/add";
		
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editGet(String id,Model model){
		Drug drug = service.findOne(id);
		model.addAttribute("drug", drug);
		
		return "drug/edit";
		
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editPost(@RequestParam("img") MultipartFile img, HttpServletRequest request,Drug drug,Model model) throws IOException{
		
		// 1.获得上传的对象
		
		// 2.获得最终上传的目的地路径(上传至服务器中当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("上传"+realPath);
		System.out.println("接收对象"+drug);
		// 2.1 将最终的目的文件夹创建出来
		File file = new File(realPath);
		// 判断该文件是否存在
		if(file.exists()){
			// 不存在则创建出
			file.mkdir();
		}
		// 2.2 获得文件名
		// 文件名重复时不能重复上传文件
		String fileName = img.getOriginalFilename();
		
		// 把文件名封装进对象
		drug.setDrug_url(fileName);
		
		System.out.println("文件名"+fileName);
		// 2.3 确定上传路径
		File newFile = new File(file,fileName);
		
		// 3.上传
		FileUtils.writeByteArrayToFile(newFile, img.getBytes());

		int rowNum = service.editDrug(drug);
		if(rowNum > 0){
			return "forward:/drug/list";
		}
		model.addAttribute("msg", "更新失败请重试");
		return null;
		
	}
	
	
	
	
	
	
	
}
