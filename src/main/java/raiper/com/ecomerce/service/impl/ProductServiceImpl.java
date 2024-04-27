package raiper.com.ecomerce.service.impl;

import org.springframework.stereotype.Service;
import raiper.com.ecomerce.model.Product;
import raiper.com.ecomerce.repository.AddressRepository;
import raiper.com.ecomerce.repository.CategoryRepository;
import raiper.com.ecomerce.repository.ProductRepository;
import raiper.com.ecomerce.repository.SupplierRepository;
import raiper.com.ecomerce.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private SupplierRepository supplierRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createNewProduct(Product product) {
        var category = categoryRepository.findByCategoryName(product.getProductName());
        if(category.isPresent()) {
            product.setCategory(category.get());
        }
        var supplier = supplierRepository.findBySupplierEmail(product.getSupplier().getSupplierEmail());
        if(supplier.isPresent()) {
            product.setSupplier(supplier.get());
        }
        return  productRepository.save(product);
    }
}
