package com.zhiyou100.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author 	拾肆
 * @date	2019年9月26日
 * @desc	创建自定义域类实现认证
 * 
 * AuthenticatingRealm : 只能做认证
 * AuthorizingRealm  : 先认证再授权
 */
public class MyRealm1 extends AuthorizingRealm{
	
	
	/**
	 * 授权 : 在执行判断是否拥有某些角色或权限是调用这些方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 通过身份的对象获得登录时的身份信息
		String  username = (String) principals.getPrimaryPrincipal();
		System.out.println("授权获得的身份: "+username);
		/*
		 * 调用业务层方法查所有角色
		 * List<String> roles = findUserByName(username);
		 * 调用业务层查所有权限
		 * Set set = new TreeSet();
		 * for(int i = 0;i<roles.size;i++){
		 * List<String> resource = findResourceByRole(roles.get(i));
		 * set.add(resource);  // set集合权限去重
		 * }
		 */
		List<String> roles = new ArrayList<>();
		roles.add("admin");
		roles.add("user");
		List<String> resource = new ArrayList<>();
		resource.add("/user/select");
		resource.add("/user/del");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roles);
		info.addStringPermissions(resource);
		
		return info;
	}
	
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 从token获取用户名
		/*
		 * Principal  身份 - 用户名
		 * Credentials  凭证 - 密码
		 */
		String uesrname = (String) token.getPrincipal();
		System.out.println("身份 : "+uesrname);
		Object credentials = token.getCredentials();
		System.out.println("凭证 : "+credentials);
		/*
		 * 根据用户名,调用业务层service,查询用户信息.返回用户对象
		 * User user = userservice.findUserByName(token.getPrincipal());
		 * if(user == null){
		 * throw new UnknownAccountException();
		 * }
		 */
		
		/*
		 * 现在是写死,以后查询
		 */
		String un = "lisi";
		String pwd = "123456";
		
		/*
		 * 比较
		 */
		if(uesrname.equals(un)){
			System.out.println("找到用户");
		}else{
			throw new UnknownAccountException();
		}
		
		// 从数据库中查出的数据
//		AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername,user.getPassword,this.getName());
		AuthenticationInfo info = new SimpleAuthenticationInfo(un,pwd,this.getName());
		return info;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	


}
