package com.raphael.order_service.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items-table")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idItem;

    @ManyToOne
    @JoinColumn(name = "orders_fk_id")
    private Orders order;

    @OneToOne
    @JoinColumn(name = "products_fk_id")
    private Products product;

    private BigDecimal valueOfItem;
    private int amount;
}
