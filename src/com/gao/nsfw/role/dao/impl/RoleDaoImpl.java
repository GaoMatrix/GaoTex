package com.gao.nsfw.role.dao.impl;

import org.hibernate.Query;

import com.gao.core.dao.impl.BaseDaoImpl;
import com.gao.nsfw.role.dao.IRoleDao;
import com.gao.nsfw.role.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}

}
