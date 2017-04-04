package com.fan.mybatis.main;

import com.fan.mybatis.mapper.RoleMapper;
import com.fan.mybatis.params.RoleParam;
import com.fan.mybatis.po.Role;
import com.fan.mybatis.po.RoleUser;
import com.fan.mybatis.po.User;
import com.fan.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 范培忠 on 2017/3/10.
 */
public class testMain {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = null;
            User user = null;
            RoleUser roleUser = null;
            int i = 0;

            /*//直接取数据
            role = roleMapper.getRole(1L);
            role = null;

            //使用map取数据
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", "1");
            role = roleMapper.getRoleByMap(map);
            role = null;

            //使用注解取数据
            role = roleMapper.getRoleByAnnotation(1L);
            role = null;

            //使用JavaBean取数据
            RoleParam roleParam = new RoleParam();
            roleParam.setId(1L);
            role = roleMapper.getRoleByJavaBean(roleParam);
            role = null;

            //使用insertRole插入数据
            role = new Role();
            role.setRoleName("州长");
            role.setNote("美国州长");
            i = roleMapper.insertRole(role);
            i = 0;

            //使用insertRoleByJavaBean插入数据
            role = new Role();
            role.setRoleName("市长");
            role.setNote("美国的市长");
            i = roleMapper.insertRoleByJavaBean(role);
            i= 0;

            //更新id为1的数据
            role = new Role();
            role.setId(1L);
            role.setRoleName("美国总统");
            role.setNote("米国的哦");
            i = roleMapper.updateRole(role);
            i= 0;

            //使用insertRole插入待删除的数据
            role = new Role();
            role.setId(2L);
            role.setRoleName("州长xxxx");
            role.setNote("美国州长xxxx");
            i = roleMapper.insertRole(role);
            //删除
            i = roleMapper.deleteRole(role.getId());
            i= 0;

            //selectUserAndRoleByUserId
            roleUser = roleMapper.getUserAndRoleByUserId(1L);
            roleUser = null;
            List roleUsers = roleMapper.getUserAndRoleByRoleId(1L);

            user = new User();
            user.setId(1L);
            user.setUserName("T");
            //user = roleMapper.getUserIf(user);
            //user = roleMapper.getUserChoose(user);

            user = new User();
            user.setUserName("T");
            user = roleMapper.getUserWhere(user);

            user = new User();
            user.setId(1L);
            //user.setUserName("川普");
            i = roleMapper.updateUserSet(user);

            List<Long> list = new ArrayList<Long>();
            list.add(1L);
            list.add(2L);
            List list_result = roleMapper.getUserForeach(list);*/

            System.out.print(1);
            //sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (sqlSession != null) {
                //sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
