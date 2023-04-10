package by.it.academy.Truck.services;

import by.it.academy.Truck.mapper.ProductMapper;
import by.it.academy.Truck.mapper.ProductUpdateMapper;
import by.it.academy.Truck.dto.ProductRequest;
import by.it.academy.Truck.dto.ProductResponse;
import by.it.academy.Truck.dto.ProductUpdateRequest;
import by.it.academy.Truck.entities.Product;
import by.it.academy.Truck.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    private final ProductUpdateMapper updateMapper;

    @Override
    public ProductResponse getProduct(UUID id) {
        log.info("In ProductServiceImpl getProduct{}", id);
        return productRepository.findById(id)
                .map(productMapper::buildProductResponse)
                .get();
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        log.info("In ProductServiceImpl createProduct{}", productRequest);
        Product product = productMapper.buildProduct(productRequest);
        Product saveProduct = productRepository.save(product);
        return  productMapper.buildProductResponse(saveProduct);
    }

    @Override
    public List<ProductResponse> getProducts(Pageable pageable) {
        log.info("In ProductServiceImpl getProducts");
        return productRepository.findAll(pageable).stream()
                .map(productMapper::buildProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateProduct(ProductUpdateRequest productUpdateRequest) {
        log.info("In ProductServiceImpl updateProduct {}", productUpdateRequest);
        Product product = productRepository.findById(productUpdateRequest.getId()).get();
        updateMapper.updateProductFromDto(productUpdateRequest, product);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        log.info("In ProductServiceImpl deleteProduct{}", id);
        productRepository.deleteById(id);
    }
}
