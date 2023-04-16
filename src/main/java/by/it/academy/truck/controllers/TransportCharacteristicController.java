package by.it.academy.truck.controllers;

import by.it.academy.truck.dto.TransportCharacteristicResponse;
import by.it.academy.truck.services.TransportCharacteristicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping
@RequiredArgsConstructor
public class TransportCharacteristicController {

    private final TransportCharacteristicService transportCharacteristicServiceImpl;

    @GetMapping("/transportcharacteristic/{id}")
    public TransportCharacteristicResponse getTransportCharacteristic(@PathVariable Integer id) {
        return transportCharacteristicServiceImpl.getTransportCharacteristic(id);
    }

    @GetMapping("/transportcharacteristics")
    public List<TransportCharacteristicResponse> getTransportCharacteristics(Pageable pageable) {
        return transportCharacteristicServiceImpl.getTransportCharacteristics(pageable);
    }
}
