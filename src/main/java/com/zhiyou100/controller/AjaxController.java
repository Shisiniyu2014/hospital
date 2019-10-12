package com.zhiyou100.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.fabric.Response;
import com.zhiyou100.model.Drug;
import com.zhiyou100.model.ResponseObject;
import com.zhiyou100.service.AjaxService;
import com.zhiyou100.util.FastDFSUtil;

@Controller
public class AjaxController {
	
	@Autowired
	private AjaxService service;
	
	@RequestMapping("/checkUser")
	public void checkUser(String usernameJsonkey,HttpServletResponse resp) throws IOException{
		String code = service.checkUser(usernameJsonkey);
		resp.getWriter().write(code);
	}
	
	/*
	 * ajax上传到tomcat服务器回显
	 */
	
	@RequestMapping("/upload")
	@ResponseBody
	public ResponseObject ajaxUpload(MultipartFile img, HttpServletRequest request) throws IOException{
		System.err.println("斤斤计较军军军军军军军");
		// 1.获得上传的对象
		
		// 2.获得最终上传的目的地路径(上传至服务器中当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("上传"+realPath);
	
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
		
		System.out.println("文件名"+fileName);
		// 2.3 确定上传路径
		File newFile = new File(file,fileName);
		
		// 3.上传
		FileUtils.writeByteArrayToFile(newFile, img.getBytes());

		request.setAttribute("path", "/upload/"+fileName);
		String path = "/upload/"+fileName;
	
		return new ResponseObject("200","成功",path);
	}
	
	/*
	 * ajax上传到FastDFS回显
	 */
	
	@RequestMapping("/uploadFastDFS")
	@ResponseBody
	public ResponseObject ajaxUpload2(MultipartFile img) throws IOException, MyException{
		
		ResponseObject obj = FastDFSUtil.upload(img);
	
		return obj;
	}
	
	@RequestMapping("/download")
	public void ajaxDownload(String fid,HttpServletResponse resp) throws IOException, MyException{
		System.err.println("下载接收fid"+fid);
		byte[] bytes = FastDFSUtil.download(fid);
		
		String[] split = fid.split("\\.");
		String suffix = split[1];
		
		//解决响应中文文件名乱码问题
		// String filename= URLEncoder.encode("用户信息表","utf-8")
		//浏览器响应下载弹框
		resp.setHeader("Content-disposition","attachment;filename="+new Date().getTime()+"."+suffix);
		resp.setContentType("image/"+suffix);
		ServletOutputStream outputStream = resp.getOutputStream();
		outputStream.write(bytes);//输出数据
		outputStream.flush();
		outputStream.close();

	}
	
	
	
	
	
	
	
	
	
	
	
}
