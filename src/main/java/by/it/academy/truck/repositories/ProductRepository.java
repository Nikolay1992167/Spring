package by.it.academy.truck.repositories;

import by.it.academy.truck.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByLoadingLocation(String location, Pageable pageable);

    List<Product> findByWeightGreaterThanEqualAndWeightLessThanEqual(Integer minWeight, Integer maxWeight);
}
