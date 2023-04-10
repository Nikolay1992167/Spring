package by.it.academy.Truck.dto;

import by.it.academy.Truck.entities.TransportCharacteristic;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ProductRequest {
    @NotBlank
    private String name;
    @NotNull
    private Integer weight;
    @NotBlank
    private String loadingLocation;
    @NotBlank
    private String unloadingLocation;
    @NotNull
    private Integer cargoCost;
    @NotNull
    private TransportCharacteristic transportCharacteristic;
}
