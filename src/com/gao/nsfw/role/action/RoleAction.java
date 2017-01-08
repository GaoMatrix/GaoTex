package com.gao.nsfw.role.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import com.gao.core.dao.constant.Constant;
import com.gao.nsfw.role.entity.Role;
import com.gao.nsfw.role.entity.RolePrivilege;
import com.gao.nsfw.role.entity.RolePrivilegeId;
import com.gao.nsfw.role.service.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {
	@Resource
	private IRoleService roleService;
	private Role role;
	private List<Role> roleList;
	private String[] privilegeIds;

	// 列表页面
	public String listUI() {
		roleList = roleService.findObjects();
		return "listUI";
	}

	// 跳转到新增界面
	public String addUI() {
		// 加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		return "addUI";
	}

	// 保存新增
	public String add() {
		if (null != role) {
			// 处理权限保存
			if (privilegeIds != null) {
				HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
				for (int i = 0; i < privilegeIds.length; i++) {
					set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
				}
				role.setRolePrivileges(set);
			}
			roleService.save(role);
		}
		return "list";
	}

	// 调转到编辑页面
	public String editUI() {
		return "editUI";
	}

	// 保存编辑
	public String edit() {
		if (null != role) {
			// 处理权限保存
			if (privilegeIds != null) {
				HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
				for (int i = 0; i < privilegeIds.length; i++) {
					set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
				}
				role.setRolePrivileges(set);
			}
			roleService.update(role);
		}
		return "list";
	}

	// 删除
	public String delete() {
		if (role != null && role.getRoleId() != null) {
			roleService.delete(role.getRoleId());
		}
		return "list";
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
	

}
