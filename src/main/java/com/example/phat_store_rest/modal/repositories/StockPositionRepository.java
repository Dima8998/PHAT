package com.example.phat_store_rest.modal.repositories;

import com.example.phat_store_rest.modal.entities.StockPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPositionRepository extends JpaRepository<StockPosition, Integer> {
}
