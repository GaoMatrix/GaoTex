package com.gao.nsfw.role.service;

import java.io.Serializable;
import java.util.List;

import com.gao.nsfw.role.entity.Role;

public interface IRoleService {
	/**
	 * 新增
	 */
	public void save(Role role);

	/**
	 * 更新
	 * 
	 * @param role
	 */
	public void update(Role role);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void delete(Serializable id);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public Role findObjectById(Serializable id);

	/**
	 * 查找列表
	 * 
	 * @return
	 */
	public List<Role> findObjects();
}
