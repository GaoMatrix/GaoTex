package com.gao.nsfw.user.action;

import java.util.List;

import javax.annotation.Resource;

import com.gao.nsfw.user.entity.User;
import com.gao.nsfw.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{
	@Resource
	private UserService userService;
	private User user;
	private List<User> userList;
	
	// 列表页面
	public String listUI() {
		userList = userService.findObjects();
		return "listUI";
	}
	
	// 跳转到新增界面
	public String addUI() {
		return "addUI";
	}
	
	// 保存新增
	public String add() {
		if (null != user) {
			userService.save(user);
		}
		return "list";
	}
	
	// 调转到编辑页面
	public String editUI() {
		return "editUI";
	}
	
	// 保存编辑
	public String edit() {
		if (null != user) {
			userService.update(user);
		}
		return "list";
	}
	
	// 删除
	public String delete() {
		if(user != null && user.getId() != null){
			userService.delete(user.getId());
		}
		return "list";
	}
	
	// 批量删除
	public String deleteSelected() {
		return "list";
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
