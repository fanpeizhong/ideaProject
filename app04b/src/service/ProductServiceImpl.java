package service;

import domain.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by 范培忠 on 2017/1/21.
 */
@Service
public class ProductServiceImpl implements ProductService{
    private Map<Long, Product> products = new HashMap<Long, Product>();
    private AtomicLong generator = new AtomicLong();

    public ProductServiceImpl() {
        Product product = new Product();
        product.setName("Power Drill");
        product.setDescription("Powerful hand drill...");
        product.setPrice(129.99F);
        add(product);
    }

    @Override
    public Product add(Product product) {
        long newId = generator.incrementAndGet();
        product.setId(newId);
        products.put(newId, product);
        return product;
    }

    @Override
    public Product get(long id) {
        return products.get(id);
    }
}
