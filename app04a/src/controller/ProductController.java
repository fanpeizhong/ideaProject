package controller;

import domain.Product;
import form.ProductForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 范培忠 on 2017/1/19.
 */
@Controller
public class ProductController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/product_input")
    public String inputProduct() {
        logger.info("ProductController.inputProduct called.");
        return "ProductForm";
    }

    @RequestMapping(value = "/product_save")
    public String saveProduct(ProductForm productForm, Model model) {
        logger.info("ProductController.saveProduct called.");

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //saved

        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
