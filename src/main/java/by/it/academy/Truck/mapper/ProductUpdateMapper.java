package by.it.academy.Truck.mapper;

import by.it.academy.Truck.dto.ProductUpdateRequest;
import by.it.academy.Truck.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductUpdateMapper {
    void updateProductFromDto(ProductUpdateRequest productUpdateRequest, Product product);

}
