package by.it.academy.Truck.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "CHARACTERISTICS")
@NoArgsConstructor
public class TransportCharacteristic {
    @Id
    @Column(name = "CHARACTERISTIC_ID", nullable = false, length = 10)
    private Integer id;
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    @Column(name = "VOLUME_FACTOR")
    private Integer volumeFactor;
    @OneToMany(mappedBy = "transportCharacteristic", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();
}

