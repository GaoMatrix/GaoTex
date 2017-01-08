package com.gao.nsfw.user.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.gao.nsfw.user.entity.User;
import com.gao.nsfw.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{
	@Resource
	private IUserService userService;
	private User user;
	private List<User> userList;
	private String[] selectedRow;
	private File headImg;
	private String headImgContentType;
	private String headImgFileName;
	
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
			// 处理头像
			if (headImg != null) {
				//1、保存头像到upload/user
				//获取保存路径的绝对地址
				String filePath = ServletActionContext.getServletContext()
						.getRealPath("upload/user");
				String fileName = UUID.randomUUID().toString() 
						+ headImgFileName.substring(headImgFileName.lastIndexOf("."));
				// 复制文件
				try {
					FileUtils.copyFile(headImg, new File(filePath, fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				//2、设置用户头像路径
				user.setHeadImg("user/" + fileName);// user/123.jpg
			}
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
			// 处理头像
			if (headImg != null) {
				//1、保存头像到upload/user
				//获取保存路径的绝对地址
				String filePath = ServletActionContext.getServletContext()
						.getRealPath("upload/user");
				String fileName = UUID.randomUUID().toString() 
						+ headImgFileName.substring(headImgFileName.lastIndexOf("."));
				// 复制文件
				try {
					FileUtils.copyFile(headImg, new File(filePath, fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				//2、设置用户头像路径
				user.setHeadImg("user/" + fileName);// user/123.jpg
			}
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
		if (selectedRow != null) {
			for (String id : selectedRow) {
				userService.delete(id);
			}
		}
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

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	
	
	
}
