package domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 范培忠 on 2017/2/3.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -5521544309275815404L;
    @NotNull(message = "Name is Empty....(in Product Class message)")
    private String name;
    private String description;
    private Float price;
    private Date productionDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
