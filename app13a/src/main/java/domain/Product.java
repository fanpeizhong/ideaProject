package domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 范培忠 on 2017/2/3.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -5521544309275815404L;

//    @NotEmpty(message = "Name is Empty, please input product's name.")
    @NotEmpty
    private String name;
//    @Length(max = 100, message = "Description's length can not long than 100.")
    @Length(max = 100)
    private String description;
//    @Min(value = 0, message = "The price of product can not be negative.")
    @Min(value = 0)
    private Float price;
//    @Past(message = "The date of product must be past.")
    @Past
    private Date productionDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Product.name:[" + this.name + "]");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
