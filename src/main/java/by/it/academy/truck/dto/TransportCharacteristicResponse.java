package by.it.academy.truck.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransportCharacteristicResponse {
    private Integer id;
    private String name;
    private Integer volumeFactor;
}
