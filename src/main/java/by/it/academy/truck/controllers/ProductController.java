package by.it.academy.truck.controllers;

import by.it.academy.truck.dto.ProductRequest;
import by.it.academy.truck.dto.ProductResponse;
import by.it.academy.truck.dto.ProductUpdateRequest;
import by.it.academy.truck.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productServiceImpl;

    @GetMapping("/products/{id}")
    public ProductResponse getProduct(@PathVariable UUID id) {
        return productServiceImpl.getProduct(id);
    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts(Pageable pageable) {
        return productServiceImpl.getProducts(pageable);
    }

    @PostMapping("/product")
    public ProductResponse createProduct(@Validated @RequestBody ProductRequest productRequest) {
        return productServiceImpl.createProduct(productRequest);
    }

    @PutMapping("/update/product")
    public void updateProduct(@Validated @RequestBody ProductUpdateRequest productUpdateRequest) {
        productServiceImpl.updateProduct(productUpdateRequest);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productServiceImpl.deleteProduct(id);
    }
}
