package by.it.academy.truck.mapper;

import by.it.academy.truck.dto.TransportCharacteristicResponse;
import by.it.academy.truck.entities.TransportCharacteristic;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class TransportCharacteristicMapper {
    public TransportCharacteristicResponse buildTransportCharacteristicResponseResponse(TransportCharacteristic transportCharacteristic) {
        return TransportCharacteristicResponse.builder()
                .id(transportCharacteristic.getId())
                .name(transportCharacteristic.getName())
                .volumeFactor(transportCharacteristic.getVolumeFactor())
                .build();
    }
}
