package com.example.phat_store_rest.modal.repositories;

import com.example.phat_store_rest.modal.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
