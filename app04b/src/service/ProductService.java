package service;

import domain.Product;

/**
 * Created by 范培忠 on 2017/1/21.
 */
public interface ProductService {
    Product add(Product product);

    Product get(long id);
}
