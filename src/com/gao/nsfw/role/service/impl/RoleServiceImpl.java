package com.gao.nsfw.role.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gao.nsfw.role.dao.IRoleDao;
import com.gao.nsfw.role.entity.Role;
import com.gao.nsfw.role.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Resource
	private IRoleDao roleDao;

	@Override
	public void save(Role role) {
		roleDao.save(role);
	}

	@Override
	public void update(Role role) {
		// 1.删除该角色对应的所有权限
		roleDao.deleteRolePrivilegeByRoleId(role.getRoleId());
		// 2.更新角色及其权限
		roleDao.update(role);
	}

	@Override
	public void delete(Serializable id) {
		roleDao.delete(id);
	}

	@Override
	public Role findObjectById(Serializable id) {
		return roleDao.findObjectById(id);
	}

	@Override
	public List<Role> findObjects() {
		return roleDao.findObjects();
	}

}
