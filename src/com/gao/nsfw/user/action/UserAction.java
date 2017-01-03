package com.gao.nsfw.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	// 列表页面
	public String listUI() {
		System.out.println("listUI");
		return "listUI";
	}
	
	// 跳转到新增界面
	public String addUI() {
		return "addUI";
	}
	
	// 保存新增
	public String add() {
		return "list";
	}
	
	// 调转到编辑页面
	public String editUI() {
		return "editUI";
	}
	
	// 保存编辑
	public String edit() {
		return "list";
	}
	
	// 删除
	public String delete() {
		return "delete";
	}
	
	// 批量删除
	public String deleteSelected() {
		return "list";
	}
}
