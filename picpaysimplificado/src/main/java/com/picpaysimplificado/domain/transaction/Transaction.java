package com.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    // um usuario pode ter varias transações , por isso a anotação, mas uma transação só pode ter um sender
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;

}
