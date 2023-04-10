package by.it.academy.Truck.services;

import by.it.academy.Truck.dto.ProductRequest;
import by.it.academy.Truck.dto.ProductResponse;
import by.it.academy.Truck.dto.ProductUpdateRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponse getProduct(UUID id);

    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts(Pageable pageable);

    void updateProduct(ProductUpdateRequest productUpdateRequest);

    void deleteProduct(UUID id);
}
