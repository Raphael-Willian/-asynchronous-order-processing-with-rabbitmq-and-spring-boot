package com.raphael.order_service.repositorys;

import com.raphael.order_service.models.Products;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, UUID> {
}
