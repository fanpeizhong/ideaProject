package service;

import pojo.RoleBean;

import java.util.List;

/**
 * Created by 范培忠 on 2017/3/19.
 */
public interface RoleService {
    public int insertRole(RoleBean roleBean);
    public int deleteRole(Integer id);
    public int updateRole(RoleBean roleBean);
    public RoleBean getRole(Integer id);
    public List<RoleBean> findRoles(String name, int start, int limit);
}
