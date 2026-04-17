package com.raphael.order_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products-table")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idProduct;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Orders order;

    private String nameProduct;
    private String description;
    private int amount;
    private BigDecimal priceOfProduct;


}
