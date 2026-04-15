package com.raphael.order_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders-table")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idOrder;

    @OneToOne(mappedBy = "order")
    private List<Items> itemsOrder;

    private BigDecimal totalValue;


}
