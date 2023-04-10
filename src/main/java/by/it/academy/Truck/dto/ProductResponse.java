package by.it.academy.Truck.dto;

import by.it.academy.Truck.entities.TransportCharacteristic;
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

    private TransportCharacteristic transportCharacteristic;
}
