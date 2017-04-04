package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.RoleBean;
import service.RoleService;

/**
 * Created by 范培忠 on 2017/3/19.
 */
@Controller
public class RoleController {
    private static Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    RoleService roleService = null;

    @RequestMapping(value = "getRole/{id}")
    public String getRole(@PathVariable(value = "id") Integer id, Model model) {
        logger.info("id:[" + id + "]");
        RoleBean roleBean = roleService.getRole(id);
        model.addAttribute("roleBean", roleBean);
        return "RoleDetails";
    }

}
