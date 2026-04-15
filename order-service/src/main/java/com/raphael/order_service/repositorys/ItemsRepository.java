package com.raphael.order_service.repositorys;

import com.raphael.order_service.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemsRepository extends JpaRepository<Items, UUID> {
}
