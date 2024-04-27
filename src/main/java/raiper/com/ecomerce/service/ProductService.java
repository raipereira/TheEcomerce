package raiper.com.ecomerce.service;

import raiper.com.ecomerce.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Product createNewProduct(Product product);
}
