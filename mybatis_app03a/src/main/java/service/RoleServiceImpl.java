package service;

import dao.RoleDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.RoleBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 范培忠 on 2017/3/19.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDAO roleDAO;
//
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertRole(RoleBean roleBean) {
        logger.info("RoleServiceImpl.insertRole() name:[" + roleBean.getRoleName() + "]");
        return this.roleDAO.insertRole(roleBean);
//        return 1;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteRole(Integer id) {
        logger.info("role id:[" + id + "]");
//        return this.roleDAO.deleteRole(id);
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public RoleBean getRole(Integer id) {
        logger.info("RoleServiceImpl.getRole() id:[" + id + "]");
        return this.roleDAO.getRole(id);
        /*RoleBean roleBean = new RoleBean();
        roleBean.setId(id);
        roleBean.setRoleName("总统");
        roleBean.setCreateDate(new Date());
        roleBean.setNote("现任");
        return roleBean;*/
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS)
    public List<RoleBean> findRoles(String name, int start, int limit) {
        logger.info("name:[" + name + "], start:[" + start + "], limit:[" + limit + "]");
//        return this.roleDAO.findRoles(name, new RowBounds(start, limit));
        List<RoleBean> list =new ArrayList<RoleBean>();

        RoleBean roleBean = new RoleBean();
        roleBean.setId(1);
        roleBean.setRoleName("总统");
        roleBean.setNote("现任");

        roleBean = new RoleBean();
        roleBean.setId(2);
        roleBean.setRoleName("国务卿");
        roleBean.setNote("现任");

        list.add(roleBean);
        return list;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public int updateRole(RoleBean roleBean) {
        logger.info("role id:[" + roleBean.getId() + "]");
//        return this.roleDAO.updateRole(roleBean);
        return 1;
    }
}
