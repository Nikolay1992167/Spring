package by.it.academy.truck.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class TransportCharacteristicRequest {
    @NotNull
    @Size(max = 10)
    private Integer id;
    @NotBlank
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 10)
    private Integer volumeFactor;
}
