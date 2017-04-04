package controller;

import domain.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 范培忠 on 2017/1/30.
 */
@Controller
public class EmployeeController {
    private static final Log logger = LogFactory.getLog(EmployeeController.class);

    @RequestMapping(value = "/employee_input")
    public String inputEmployee(Model model) {
        //model.addAttribute("employee", new Employee()); //和下面这句的写法都是可以的。下面这句是用Employee的类名小写作为隐含对象名
        model.addAttribute(new Employee());
        return "EmployeeForm";
    }

    @RequestMapping(value = "/employee_save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
            return "EmployeeForm";
        }

        //saved

        model.addAttribute("employee", employee);
        return "EmployeeForm";
    }
}
