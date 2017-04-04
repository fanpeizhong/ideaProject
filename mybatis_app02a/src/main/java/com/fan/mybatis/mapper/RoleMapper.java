package com.fan.mybatis.mapper;

import com.fan.mybatis.params.RoleParam;
import com.fan.mybatis.po.Role;
import com.fan.mybatis.po.RoleUser;
import com.fan.mybatis.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 范培忠 on 2017/3/10.
 */
public interface RoleMapper {
    public Role getRole(Long id);
    public Role getRoleByMap(Map<String, String> map);
    public Role getRoleByAnnotation(@Param(value = "id") Long id);
    public Role getRoleByJavaBean(RoleParam roleParam);
    public User getUserIf(User user);
    public User getUserChoose(User user);
    public User getUserWhere(User user);
    public List getUserForeach(List users);

    public RoleUser getUserAndRoleByUserId(Long id);
    public List getUserAndRoleByRoleId(Long id);

    public int insertRole(Role role);
    public int insertRoleByJavaBean(Role role);

    public int updateRole(Role role);
    public int updateUserSet(User user);

    public int deleteRole(Long id);
}
