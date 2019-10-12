package com.zhiyou100.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.model.ResponseObject;

/**
 * @author 	拾肆
 * @date	2019年9月23日
 * @desc	
 * 
 * FastDFS工具类
 * 上传
 * 下载
 * 删除
 */
public class FastDFSUtil {
	
	/*
	 * 1. 依赖/jar
	 * 2. FastDFS 配置文件
	 * 3. javaapi
	 * 加载配置文件
	 * 创建 Tracker客户端
	 * 通过 Tracker客户端得到 Tracker对象
	 * 通过 Tracker得到 Storage客户端
	 * 创建文件属性存储对象
	 * 通过客户端执行上传
	 */
	
	public static ResponseObject upload(MultipartFile img) throws IOException, MyException{
		 
		String fileName = img.getOriginalFilename();
		
		// 把文件名封装进对象
		String[] split = fileName.split("\\.");
		String suffix = split[1];
		
		
		
		 // 加载配置文件
		ClientGlobal.init("D:\\workspace_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		 // 创建 Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		 // 通过 Tracker客户端得到 Tracker对象
		TrackerServer connection = trackerClient.getConnection();
		 // 通过 Tracker得到 Storage客户端
		StorageClient1 storageClient = new StorageClient1(connection, null);
		 // 创建文件属性存储对象
		
//		NameValuePair meta_list [] = new NameValuePair[]{ 
//					new NameValuePair("item_id", "100010"), 
//	                new NameValuePair("width", "80"),
//	                new NameValuePair("height", "90")
//	        };

			NameValuePair[] list = new NameValuePair[1];
			list[0] = new NameValuePair("fileName", fileName);
		 // 通过客户端执行上传
		 
			/*
			 * 参数1:要上传的文件地址
			 * 参数2:要上传的文件类型
			 * 参数3:文件属性信息对象数组
			 * 返回值 : 存储在Storage中的地址
			 */
			String fid = storageClient.upload_file1(img.getBytes(), suffix, list);
			System.out.println("成功 : "+ fid);
			System.out.println("结束");
			String path = "http://Java2101:80/"+fid;
			Map<String,String> map = new HashMap<>();
			map.put("fid", fid);
			map.put("path", path);
			return new ResponseObject("200","成功",map);
		
	
	}
	
	public static byte[] download(String fid) throws IOException, MyException{
		
		 // 加载配置文件
		ClientGlobal.init("D:\\workspace_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		 // 创建 Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		 // 通过 Tracker客户端得到 Tracker对象
		TrackerServer connection = trackerClient.getConnection();
		 // 通过 Tracker得到 Storage客户端
		StorageClient1 storageClient = new StorageClient1(connection, null);
		//通过客户端执行下载
		byte[] bytes = storageClient.download_file1(fid);

		return bytes;
		
		
	}
	
	
	
	
	
}
