package form;

import java.io.Serializable;

/**
 * Created by pzh.fan on 2017/1/17.
 */
public class ProductForm implements Serializable {
    private static final long serialVersionUID = 8258664786577237117L;
    private String name;
    private String description;
    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
