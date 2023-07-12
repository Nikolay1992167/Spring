package by.it.academy.truck.mapper;

import by.it.academy.truck.dto.ProductRequest;
import by.it.academy.truck.dto.ProductResponse;
import by.it.academy.truck.dto.TransportCharacteristicRequest;
import by.it.academy.truck.dto.TransportCharacteristicResponse;
import by.it.academy.truck.entities.Product;
import by.it.academy.truck.entities.TransportCharacteristic;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class ProductMapper {
    public ProductResponse buildProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .weight(product.getWeight())
                .loadingLocation(product.getLoadingLocation())
                .unloadingLocation(product.getUnloadingLocation())
                .cargoCost(product.getCargoCost())
                .transportCharacteristicResponse(transportCharacteristicResponseToTransportCharacteristic(product.getTransportCharacteristic()))
                .build();
    }

    public Product buildProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .weight(productRequest.getWeight())
                .loadingLocation(productRequest.getLoadingLocation())
                .unloadingLocation(productRequest.getUnloadingLocation())
                .cargoCost(productRequest.getCargoCost())
                .transportCharacteristic(transportCharacteristicToTransportCharacteristicRequest(productRequest.getTransportCharacteristicRequest()))
                .build();
    }


    private TransportCharacteristicResponse transportCharacteristicResponseToTransportCharacteristic(TransportCharacteristic transportCharacteristic) {
        return TransportCharacteristicResponse.builder()
                .id(transportCharacteristic.getId())
                .name(transportCharacteristic.getName())
                .volumeFactor(transportCharacteristic.getVolumeFactor())
                .build();
    }

    private TransportCharacteristic transportCharacteristicToTransportCharacteristicRequest(TransportCharacteristicRequest transportCharacteristicRequest) {
        return TransportCharacteristic.builder()
                .id(transportCharacteristicRequest.getId())
                .name(transportCharacteristicRequest.getName())
                .volumeFactor(transportCharacteristicRequest.getVolumeFactor())
                .build();
    }
}
