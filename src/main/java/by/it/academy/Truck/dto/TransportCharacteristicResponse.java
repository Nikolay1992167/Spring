package by.it.academy.Truck.dto;

import by.it.academy.Truck.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TransportCharacteristicResponse {

    private Integer id;

    private String name;

    private Integer volumeFactor;

    private Set<Product> products;
}
