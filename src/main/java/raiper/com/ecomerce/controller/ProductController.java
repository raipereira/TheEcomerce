package raiper.com.ecomerce.controller;

import org.springframework.web.bind.annotation.*;
import raiper.com.ecomerce.dto.converter.dtoToEntity.ConverterRequestToProduct;
import raiper.com.ecomerce.dto.converter.entityToDto.ConverterProductToDto2;
import raiper.com.ecomerce.dto.request.ProductRequest;
import raiper.com.ecomerce.model.Product;
import raiper.com.ecomerce.result.Result;
import raiper.com.ecomerce.result.StatusCode;
import raiper.com.ecomerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService service;

    private ConverterProductToDto2 productToDto;
    private ConverterRequestToProduct converterRequestToProduct;

    public ProductController(ProductService service, ConverterProductToDto2 productToDto,
                             ConverterRequestToProduct converterRequestToProduct) {
        this.service = service;
        this.productToDto = productToDto;
        this.converterRequestToProduct = converterRequestToProduct;
    }

    @GetMapping
    public Result getAllProducts() {
        var products = service.findAllProducts();
        var productDto = products.stream().map(product -> productToDto.convert(product)).toList();
        return new Result(true, StatusCode.SUCCESS, "Find All Success", productDto);
    }

    @PostMapping
    public Result addNewProduct(@RequestBody ProductRequest request) {
        var product = service.createNewProduct(converterRequestToProduct.convert(request));
        var productResponse = productToDto.convert(product);
        return new Result(true, StatusCode.SUCCESS, "Add Success", productResponse);
    }
}
