package com.zhiyou100;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestMycat {
	
	public static void main(String[] args) throws Exception {
		for (int i = 9;i < 9;i++){
		Class.forName("com.mysql.jdbc.Driver");
		// mycat的用户名
		String username = "qsj";
		// mycat的密码
		String password = "123456";
		// mycat的连接地址
		String url = "jdbc:mysql://192.168.142.132:8066/qsj_table";
		Connection conn = DriverManager.getConnection(url,username,password);
			
		String sql1 = "insert into dept (d_id,d_name,d_desc) values ("+i+",'mycat研发部"+i+"','客户端插入"+i+"')";
		String sql2 = "insert into user (u_name,u_desc) values ('u_lisi','客户端插入用户lisi')";
		String sql3 = "insert into student (s_name,s_desc) values ('s_zs','客户端插入学生zs')";
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		ps1.execute();
		ps2.execute();
		ps3.execute();
		ps1.close();
		ps3.close();
		ps2.close();
		conn.close();
		}
		System.out.println("成功");
	}
	
	
}
