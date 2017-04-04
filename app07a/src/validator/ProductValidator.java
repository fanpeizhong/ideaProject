package validator;

import domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

/**
 * Created by 范培忠 on 2017/2/3.
 */
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "productName.required");
        ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
        ValidationUtils.rejectIfEmpty(errors, "productionDate", "productionDate.required");
        Float price = product.getPrice();
        if (price != null && price < 0) {
            errors.rejectValue("price", "price.negative");
        }
        Date productDate = product.getProductionDate();
        if (productDate == null || productDate.after(new Date())) {
            errors.rejectValue("productionDate", "productionDate.invalid");
        }
    }
}
