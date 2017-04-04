package domain;

import java.io.Serializable;

/**
 * Created by pzh.fan on 2017/1/17.
 */
public class Product implements Serializable{
    private static final long serialVersionUID = -5521544309275815404L;
    private String name;
    private String description;
    private float price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
