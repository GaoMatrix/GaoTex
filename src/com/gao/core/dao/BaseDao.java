package com.gao.core.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<T> {

	/**
	 * 新增
	 */
	public void save(T entity);
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity);
	
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
	public T findObjectById(Serializable id);
	
	/**
	 * 查找列表
	 * @return
	 */
	public List<T> findObjects();
}
