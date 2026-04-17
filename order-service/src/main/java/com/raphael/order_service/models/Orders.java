package com.raphael.order_service.models;

import com.raphael.order_service.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @OneToMany(mappedBy = "order")
    private List<Products> productsOrder;
    private BigDecimal totalValue;
    private OrderStatus statusOrder;
    private LocalDateTime createdAt;

    //alters for preference Mercado Pago

    //Create preference id. Preference id is important for Mercado Pago Webhook
    private String preferenceId;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.statusOrder = OrderStatus.PENDING;
    }


}
