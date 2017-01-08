package com.gao.nsfw.role.dao;

import com.gao.core.dao.BaseDao;
import com.gao.nsfw.role.entity.Role;

public interface IRoleDao extends BaseDao<Role> {
	/**
	 * 删除该角色对应的所有权限
	 */
	public void deleteRolePrivilegeByRoleId(String roleId);
}
