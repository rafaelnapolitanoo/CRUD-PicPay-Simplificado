package com.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name= "users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    // refatorar para uuid depois, tornando mais seguro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    // nao pode existir mais de um documento
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String passWord;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;


}
