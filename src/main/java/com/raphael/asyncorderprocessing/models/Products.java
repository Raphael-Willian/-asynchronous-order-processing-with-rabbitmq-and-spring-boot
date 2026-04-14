package com.raphael.asyncorderprocessing.models;

import com.raphael.asyncorderprocessing.enums.CategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Products {

    @Id
    private UUID idProduct;

    private String name;
    private String description;
    private BigDecimal value;
    private CategoryEnum category;

}
