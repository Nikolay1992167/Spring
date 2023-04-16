package by.it.academy.truck.dto;

import by.it.academy.truck.entities.TransportCharacteristic;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class ProductRequest {
    @NotBlank
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 50)
    private Integer weight;
    @NotBlank
    @Size(max = 100)
    private String loadingLocation;
    @NotBlank
    @Size(max = 100)
    private String unloadingLocation;
    @NotNull
    @Size(max = 50)
    private Integer cargoCost;
    @NotNull
    private TransportCharacteristicRequest transportCharacteristicRequest;
}
