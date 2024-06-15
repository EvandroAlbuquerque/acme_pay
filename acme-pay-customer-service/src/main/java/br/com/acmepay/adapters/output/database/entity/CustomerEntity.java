package br.com.acmepay.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @SequenceGenerator(name = "customer_seq",
            sequenceName = "customer_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_seq")
    private Long id;

    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    private String customer;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String customerDocument;
}
