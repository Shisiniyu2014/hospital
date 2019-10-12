package com.zhiyou100.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author 	拾肆
 * @date	2019年9月26日
 * @desc	演示
 * 
 * 通过配置文件形式实现认证
 * 认证 : 判断用户名/密码 存在与否 对不对
 */
public class TestShiro1 {
	
	// 通过配置文件形式实现认证
	// 认证 : 判断用户名/密码 存在与否 对不对
	@Test
	public void testIniAuthentication(){
		// 通过配置文件得到SecurityManagerFactory对象
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro_show.ini");
		// 通过工厂对象得到SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 将SecurityManager对象设置为全局属性
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject,通过SecurityUtils得到
		// 通过securityManager得到subject
		Subject subject = SecurityUtils.getSubject();
		// 创建认证需要的对象: 目前是固定,应该从页面获取
		UsernamePasswordToken token = new UsernamePasswordToken("lisi","123456");
		// 执行登录: 底层是执行认证
		/*
		 * 认证通过 : 正常
		 * 不通过 : 抛异常
		 * 	1. 账户不存在    未知账户异常 UnknownAccountException
		 * 	2. 密码错误        IncorrectCredentialsException
		 */
		try{
			subject.login(token);
			System.out.println("登录成功");
		}catch(UnknownAccountException e){
			System.out.println("账户不存在");
		}catch(IncorrectCredentialsException e){
			System.out.println("密码错误");
		}
		
		
		
		
	}
	
	// 自定义Realm实现认证
	/*
	 * 修改配置文件
	 * 加入 : 使   securityManager 通过自定义域创建出
	 */
	
	@Test
	public void testRealmAuthentication(){
		// 通过配置文件得到SecurityManagerFactory对象
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-realm-authen.ini");
		// 通过工厂对象得到SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 将SecurityManager对象设置为全局属性
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject,通过SecurityUtils得到
		// 通过securityManager得到subject
		Subject subject = SecurityUtils.getSubject();
		// 创建认证需要的对象: 目前是固定,应该从页面获取
		UsernamePasswordToken token = new UsernamePasswordToken("lisi","123456");
		// 执行登录: 底层是执行认证
		/*
		 * 认证通过 : 正常
		 * 不通过 : 抛异常
		 * 	1. 账户不存在    未知账户异常 UnknownAccountException
		 * 	2. 密码错误        IncorrectCredentialsException
		 */
		try{
			subject.login(token);
			System.out.println("登录成功");
		}catch(UnknownAccountException e){
			System.out.println("账户不存在");
		}catch(IncorrectCredentialsException e){
			System.out.println("密码错误");
		}
		
		
		
		
	}

	
	@Test
	public void testIniAuthoriztion(){
		// 通过配置文件得到SecurityManagerFactory对象
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-author.ini");
		// 通过工厂对象得到SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 将SecurityManager对象设置为全局属性
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject,通过SecurityUtils得到
		// 通过securityManager得到subject
		Subject subject = SecurityUtils.getSubject();
		// 创建认证需要的对象: 目前是固定,应该从页面获取
		UsernamePasswordToken token = new UsernamePasswordToken("lisi","123456");
		// 执行登录: 底层是执行认证
		/*
		 * 认证通过 : 正常
		 * 不通过 : 抛异常
		 * 	1. 账户不存在    未知账户异常 UnknownAccountException
		 * 	2. 密码错误        IncorrectCredentialsException
		 */
		try{
			subject.login(token);
			System.out.println("登录成功");
			/*
			 * 判断角色有无对应的角色权限
			 */
			// System.out.println(subject.hasRole("role1"));
			List<String> roles = new ArrayList<String>();
			roles.add("role1");
			roles.add("role2");
			roles.add("role3");
			for(int i = 0;i<subject.hasRoles(roles).length;i++){
				System.out.println("有无角色"+(i+1)+" "+subject.hasRoles(roles)[i]);
			}
			/*
			 * 判断有无/user/add权限
			 */
			System.out.println(subject.isPermittedAll("/user/add"));
		}catch(UnknownAccountException e){
			System.out.println("账户不存在");
		}catch(IncorrectCredentialsException e){
			System.out.println("密码错误");
		}
		
		
		
		
	}
	
	
	@Test
	public void testRealmAuthoriztion(){
		// 通过配置文件得到SecurityManagerFactory对象
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-realm-author.ini");
		// 通过工厂对象得到SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 将SecurityManager对象设置为全局属性
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject,通过SecurityUtils得到
		// 通过securityManager得到subject
		Subject subject = SecurityUtils.getSubject();
		// 创建认证需要的对象: 目前是固定,应该从页面获取
		UsernamePasswordToken token = new UsernamePasswordToken("lisi","123456");
		// 执行登录: 底层是执行认证
		/*
		 * 认证通过 : 正常
		 * 不通过 : 抛异常
		 * 	1. 账户不存在    未知账户异常 UnknownAccountException
		 * 	2. 密码错误        IncorrectCredentialsException
		 */
		try{
			subject.login(token);
			System.out.println("登录成功");
			/*
			 * 判断角色有无对应的角色权限
			 */
			// System.out.println(subject.hasRole("role1"));
			List<String> roles = new ArrayList<String>();
			roles.add("admin");
			roles.add("user");
			roles.add("role3");
			for(int i = 0;i<subject.hasRoles(roles).length;i++){
				System.out.println("有无角色"+(i+1)+" "+subject.hasRoles(roles)[i]);
			}
			/*
			 * 判断有无/user/add权限
			 */
			System.out.println("有无select权限"+subject.isPermittedAll("/user/select")+"有无add权限"+subject.isPermittedAll("/user/add")+"有无del权限"+subject.isPermittedAll("/user/del"));
		}catch(UnknownAccountException e){
			System.out.println("账户不存在");
		}catch(IncorrectCredentialsException e){
			System.out.println("密码错误");
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
