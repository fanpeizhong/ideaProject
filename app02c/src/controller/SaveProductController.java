package controller;

import domain.Product;
import form.ProductForm;
import validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.FloatControl;
import java.util.List;

/**
 * Created by pzh.fan on 2017/1/17.
 */
public class SaveProductController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        //获取表单输入
        ProductForm productForm = new ProductForm();
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        //校验
        ProductValidator porductValidate = new ProductValidator();
        List<String> errors = porductValidate.validate(productForm);

        if (errors.isEmpty()) {
            //组装模型
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            //There will be save product model

            //转发到结果
            request.setAttribute("product", product);
            return request.getContextPath() + "/ProductDetails.jsp";
        } else {
            //转发到再次填写
            request.setAttribute("errors", errors);
            request.setAttribute("form", productForm);
            return request.getContextPath() + "/ProductForm.jsp";
        }
    }
}
