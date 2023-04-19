package by.it.academy.truck.repositories;

import by.it.academy.truck.entities.TransportCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportCharacteristicRepository extends JpaRepository<TransportCharacteristic, Integer> {
}
