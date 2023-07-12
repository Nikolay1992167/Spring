package by.it.academy.truck.services;

import by.it.academy.truck.dto.ProductRequest;
import by.it.academy.truck.dto.ProductResponse;
import by.it.academy.truck.dto.ProductUpdateRequest;
import by.it.academy.truck.dto.TransportCharacteristicRequest;
import by.it.academy.truck.entities.Product;
import by.it.academy.truck.entities.TransportCharacteristic;
import by.it.academy.truck.exceptions.ResourceNotFoundException;
import by.it.academy.truck.mapper.ProductMapper;
import by.it.academy.truck.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    @Override
    public ProductResponse getProduct(UUID id) {
        return productRepository.findById(id)
                .map(productMapper::buildProductResponse)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Can not find product with id %s", id)));
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.buildProduct(productRequest);
        Product saveProduct = productRepository.save(product);
        return productMapper.buildProductResponse(saveProduct);
    }

    @Override
    public List<ProductResponse> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable).stream()
                .map(productMapper::buildProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateProduct(ProductUpdateRequest productUpdateRequest) {
        Product updateProduct = productRepository.findById(productUpdateRequest.getId()).orElseThrow(() -> new ResourceNotFoundException(String.format("Not find product.")));
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
        productRepository.deleteById(id);
    }

    private TransportCharacteristic transportCharacteristicToTransportCharacteristicRequest(TransportCharacteristicRequest transportCharacteristicRequest) {
        return TransportCharacteristic.builder()
                .id(transportCharacteristicRequest.getId())
                .name(transportCharacteristicRequest.getName())
                .volumeFactor(transportCharacteristicRequest.getVolumeFactor())
                .build();
    }
    @Override
    public List<ProductResponse> getProductsByLoadingLocation(String location, Pageable pageable){
        return productRepository.findByLoadingLocation(location, pageable).stream()
                .map(productMapper::buildProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProductsByValueWeight(Integer minWeight, Integer maxWeight) {
        return productRepository.findByWeightGreaterThanEqualAndWeightLessThanEqual(minWeight, maxWeight).stream()
                .map(productMapper::buildProductResponse)
                .collect(Collectors.toList());
    }
}
