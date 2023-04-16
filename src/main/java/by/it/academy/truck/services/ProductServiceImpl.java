package by.it.academy.truck.services;

import by.it.academy.truck.dto.ProductRequest;
import by.it.academy.truck.dto.ProductResponse;
import by.it.academy.truck.dto.ProductUpdateRequest;
import by.it.academy.truck.dto.TransportCharacteristicRequest;
import by.it.academy.truck.entities.Product;
import by.it.academy.truck.entities.TransportCharacteristic;
import by.it.academy.truck.mapper.ProductMapper;
import by.it.academy.truck.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

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
        return productMapper.buildProductResponse(saveProduct);
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
        Product updateProduct = productRepository.findById(productUpdateRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid product Id"));
        updateProduct.setName(productUpdateRequest.getName());
        updateProduct.setCargoCost(productUpdateRequest.getCargoCost());
        updateProduct.setWeight(productUpdateRequest.getWeight());
        updateProduct.setLoadingLocation(productUpdateRequest.getLoadingLocation());
        updateProduct.setUnloadingLocation(productUpdateRequest.getUnloadingLocation());
        updateProduct.setTransportCharacteristic(transportCharacteristicToTransportCharacteristicRequest(productUpdateRequest.getTransportCharacteristicRequest()));
        productRepository.save(updateProduct);
    }

    @Override
    public void deleteProduct(UUID id) {
        log.info("In ProductServiceImpl deleteProduct{}", id);
        productRepository.deleteById(id);
    }

    private TransportCharacteristic transportCharacteristicToTransportCharacteristicRequest(TransportCharacteristicRequest transportCharacteristicRequest) {
        return TransportCharacteristic.builder()
                .id(transportCharacteristicRequest.getId())
                .name(transportCharacteristicRequest.getName())
                .volumeFactor(transportCharacteristicRequest.getVolumeFactor())
                .build();
    }
}
