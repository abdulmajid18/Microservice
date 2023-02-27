package com.rozz.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rozz.productservice.dto.ProductRequest;
import com.rozz.productservice.dto.ProductResponse;
import com.rozz.productservice.model.Product;
import com.rozz.productservice.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

// @RequiredArgsConstructor // You can use this annoation from lombok and ignore
// the ceated
// constructor mannually

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product  " + product.getId() + "is Saved");
        log.info("Product {} name is saved successfully!", product.getName());

    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId()).name(product.getName())
                .description(product.getDescription()).build();

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToProductResponse(product)).toList();
    }
}
