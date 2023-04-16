package by.it.academy.truck.entities;

import by.it.academy.truck.enams.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private UUID id;
    @Column(name = "COMPANY_NAME", nullable = false, length = 100)
    private String nameCompany;
    @Column(name = "LOC", nullable = false, length = 100)
    private String location;
    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;
    @Column(name = "USER_NAME", nullable = false, length = 50)
    private String userName;
    @Column(name = "USER_PASSWORD", nullable = false, length = 50)
    private String password;
    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private UserType userType;
}

