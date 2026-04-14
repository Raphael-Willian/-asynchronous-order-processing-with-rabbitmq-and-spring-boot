package com.raphael.asyncorderprocessing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idOrder;

    @ManyToOne
    private Clients client;

    @OneToMany
    private List<Products> productsOrder;
    private BigDecimal totalValue;









}
