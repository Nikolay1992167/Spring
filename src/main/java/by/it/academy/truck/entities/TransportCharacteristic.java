package by.it.academy.truck.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "TRANSPORT_CHARACTERISTICS")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "products")
@EqualsAndHashCode(exclude = "products")
public class TransportCharacteristic {
    @Id
    @Column(name = "CHARACTERISTIC_ID", nullable = false, length = 10)
    private Integer id;
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    @Column(name = "VOLUME_FACTOR", nullable = false, length = 10)
    private Integer volumeFactor;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "transportCharacteristic")
    private Set<Product> products = new HashSet<>();
}

