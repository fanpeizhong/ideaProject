package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import pojo.RoleBean;

import java.util.List;

/**
 * Created by 范培忠 on 2017/3/20.
 */
@Repository
public interface RoleDAO {
    public int insertRole(RoleBean roleBean);

    public int deleteRole(@Param(value = "id") Integer id);

    public int updateRole(RoleBean roleBean);

    public RoleBean getRole(@Param(value = "id") Integer id);

    public List<RoleBean> findRoles(@Param(value = "RoleName") String roleName, RowBounds rowBounds);
}
