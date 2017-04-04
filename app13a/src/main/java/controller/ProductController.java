package controller;
import domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by 范培忠 on 2017/2/3.
 */
@Controller
public class ProductController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/product_input")
    public String inputProduct(Model model) {
        logger.info("/product_input");
        model.addAttribute("product", new Product());
        return "ProductForm";
    }

    @RequestMapping(value = "/product_save")
    public String saveProduct(@Valid @ModelAttribute(value = "product") Product product,
                              BindingResult bindingResult, Model model) {
        logger.info("/product_save");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
            return "ProductForm";
        }

        //suppose saved

        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
