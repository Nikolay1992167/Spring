package by.it.academy.truck.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROD_ID")
    private UUID id;
    @Column(name = "PROD_NAME", nullable = false, length = 100)
    private String name;
    @Column(name = "WEIGHT", nullable = false, length = 50)
    private Integer weight;
    @Column(name = "LOADING_LOCATION", nullable = false, length = 100)
    private String loadingLocation;
    @Column(name = "UNLOADING_LOCATION", nullable = false, length = 100)
    private String unloadingLocation;
    @Column(name = "CARGO_COST", nullable = false, length = 50)
    private Integer cargoCost;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CHARACTERISTIC_ID")
    private TransportCharacteristic transportCharacteristic;
}
