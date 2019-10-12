package com.zhiyou100;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

/**
 * @author 	拾肆
 * @date	2019年9月23日
 * @desc	
 * 
 * 测试FastDFS
 * 上传
 * 下载
 * 删除
 */
public class TestFastDFS {
	
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
	@Test
	public void upload() throws IOException, MyException{
		 
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
			list[0] = new NameValuePair("fileName", "123.jpg");
		 // 通过客户端执行上传
		 
			/*
			 * 参数1:要上传的文件地址
			 * 参数2:要上传的文件类型
			 * 参数3:文件属性信息对象数组
			 * 返回值 : 存储在Storage中的地址
			 */
			String path = storageClient.upload_file1("C://Users//123//Desktop//123.jpg", "jpg", list);
			System.out.println("path : "+ path);
			System.out.println("结束");
		
	
	}
	@Test
	public void download() throws IOException, MyException{
		String fid = "group1/M00/00/00/wKiOgV2Ib8KAA_ghAAHXEZe1EOw055.jpg";
		
		 // 加载配置文件
		ClientGlobal.init("D:\\workspace_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		 // 创建 Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		 // 通过 Tracker客户端得到 Tracker对象
		TrackerServer connection = trackerClient.getConnection();
		 // 通过 Tracker得到 Storage客户端
		StorageClient1 storageClient = new StorageClient1(connection, null);
		//通过客户端执行下载
		byte[] bs = storageClient.download_file1(fid);
		OutputStream out = new FileOutputStream("C://Users//123//Desktop//1234.jpg");
		out.write(bs);
		out.close();
		System.out.println("下载成功");
		
		
	}
	
	
	
	
	
}
