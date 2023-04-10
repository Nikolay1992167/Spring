package by.it.academy.Truck.controllers;

import by.it.academy.Truck.dto.ProductRequest;
import by.it.academy.Truck.dto.ProductResponse;
import by.it.academy.Truck.dto.ProductUpdateRequest;
import by.it.academy.Truck.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productServiceImpl;

    @GetMapping("id")
    public ProductResponse getProduct(@PathVariable UUID id) {
        return productServiceImpl.getProduct(id);
    }

    @GetMapping
    public List<ProductResponse> getProducts(Pageable pageable) {
        return productServiceImpl.getProducts(pageable);
    }

    @PostMapping
    public ProductResponse createProduct(@Validated @RequestBody ProductRequest productRequest) {
        return productServiceImpl.createProduct(productRequest);
    }

    @PutMapping
    public void updateProduct(@Validated @RequestBody ProductUpdateRequest productUpdateRequest) {
        productServiceImpl.updateProduct(productUpdateRequest);
    }

    @DeleteMapping("id")
    public void deleteProduct(@PathVariable UUID id) {
        productServiceImpl.deleteProduct(id);
    }
}
