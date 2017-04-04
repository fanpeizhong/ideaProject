package controller;

import domain.Product;
import form.ProductForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.FloatControl;

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

        //转发
        request.setAttribute("product", product);
        return request.getContextPath() + "/ProductDetails.jsp";
    }
}
