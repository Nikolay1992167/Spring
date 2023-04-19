package by.it.academy.truck.services;

import by.it.academy.truck.dto.ProductRequest;
import by.it.academy.truck.dto.ProductResponse;
import by.it.academy.truck.dto.ProductUpdateRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponse getProduct(UUID id);

    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts(Pageable pageable);

    void updateProduct(ProductUpdateRequest productUpdateRequest);

    void deleteProduct(UUID id);

    List<ProductResponse> getProductsByLoadingLocation(String loadingLocation, Pageable pageable);

    List<ProductResponse> getProductsByValueWeight(Integer minWeight, Integer maxWeight);
}
