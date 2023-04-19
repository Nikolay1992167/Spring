package by.it.academy.truck.services;

import by.it.academy.truck.dto.TransportCharacteristicResponse;
import by.it.academy.truck.mapper.TransportCharacteristicMapper;
import by.it.academy.truck.repositories.TransportCharacteristicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransportCharacteristicServiceImpl implements TransportCharacteristicService {

    private final TransportCharacteristicMapper transportCharacteristicMapper;

    private final TransportCharacteristicRepository transportCharacteristicRepository;

    @Override
    public TransportCharacteristicResponse getTransportCharacteristic(Integer id) {
        return transportCharacteristicRepository.findById(id)
                .map(transportCharacteristicMapper::buildTransportCharacteristicResponseResponse)
                .get();
    }

    @Override
    public List<TransportCharacteristicResponse> getTransportCharacteristics(Pageable pageable) {
        return transportCharacteristicRepository.findAll(pageable).stream()
                .map(transportCharacteristicMapper::buildTransportCharacteristicResponseResponse)
                .collect(Collectors.toList());
    }
}
