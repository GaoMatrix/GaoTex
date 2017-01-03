package com.gao.nsfw.user.service;

import java.io.Serializable;
import java.util.List;

import com.gao.nsfw.user.entity.User;

public interface UserService {
	/**
	 * 新增
	 */
	public void save(User user);
	
	/**
	 * 更新
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public User findObjectById(Serializable id);
	
	/**
	 * 查找列表
	 * @return
	 */
	public List<User> findObjects();
}
