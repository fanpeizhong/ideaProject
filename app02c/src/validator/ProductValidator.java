package validator;

import form.ProductForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pzh.fan on 2017/1/17.
 */
public class ProductValidator {
    public List<String> validate(ProductForm productForm) {
        List<String> errors = new ArrayList<String>();

        String name = productForm.getName();
        if (name == null || name.trim().isEmpty()) {
            errors.add("Product must have a name.");
        }
        String desc = productForm.getDescription();
        if (desc == null || desc.trim().isEmpty()) {
            errors.add("Product must have a description.");
        }
        String price = productForm.getPrice();
        if (price == null || price.trim().isEmpty()) {
            errors.add("Product must have a price.");
        } else {
            try {
                Float.parseFloat(price);
            } catch (NumberFormatException e) {
                errors.add("Invalid price input.");
            }
        }

        return errors;
    }
}