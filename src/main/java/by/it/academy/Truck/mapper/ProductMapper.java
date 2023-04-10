package by.it.academy.Truck.mapper;

import by.it.academy.Truck.dto.ProductRequest;
import by.it.academy.Truck.dto.ProductResponse;
import by.it.academy.Truck.entities.Product;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class ProductMapper {
    public ProductResponse buildProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .weight(product.getWeight())
                .loadingLocation(product.getLoadingLocation())
                .unloadingLocation(product.getUnloadingLocation())
                .cargoCost(product.getCargoCost())
                .transportCharacteristic(product.getTransportCharacteristic())
                .build();
    }

    public Product buildProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .weight(productRequest.getWeight())
                .loadingLocation(productRequest.getLoadingLocation())
                .unloadingLocation(productRequest.getUnloadingLocation())
                .cargoCost(productRequest.getCargoCost())
                .transportCharacteristic(productRequest.getTransportCharacteristic())
                .build();
    }
}
