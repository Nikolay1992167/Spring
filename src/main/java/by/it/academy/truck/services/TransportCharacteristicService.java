package by.it.academy.truck.services;

import by.it.academy.truck.dto.TransportCharacteristicResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransportCharacteristicService {

    TransportCharacteristicResponse getTransportCharacteristic(Integer id);

    List<TransportCharacteristicResponse> getTransportCharacteristics(Pageable pageable);
}
