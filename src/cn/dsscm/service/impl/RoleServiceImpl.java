package cn.dsscm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.dsscm.dao.RoleMapper;
import cn.dsscm.dao.UserMapper;
import cn.dsscm.pojo.Role;
import cn.dsscm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private UserMapper userMapper;
	public List<Role> getRoleList() throws Exception{
		// TODO Auto-generated method stub
		return roleMapper.getRoleList();
	}

	public boolean add(Role role) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(roleMapper.add(role) > 0)
			flag = true;
		return flag;
	}

	public boolean deleteRoleById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(userMapper.getUserCount(null, delId) == 0){
			if(roleMapper.deleteRoleById(delId) > 0)
				flag = true;
		}
		return flag;
	}

	public boolean modify(Role role) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(roleMapper.modify(role) > 0)
			flag = true;
		return flag;
	}

	public Role getRoleById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.getRoleById(id);
	}

	public int roleCodeIsExist(String roleCode) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.roleCodeIsExist(roleCode);
	}
	
}
