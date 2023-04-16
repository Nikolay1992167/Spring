package by.it.academy.truck.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductResponse {
    private UUID id;
    private String name;
    private Integer weight;
    private String loadingLocation;
    private String unloadingLocation;
    private Integer cargoCost;
    private TransportCharacteristicResponse transportCharacteristicResponse;
}
