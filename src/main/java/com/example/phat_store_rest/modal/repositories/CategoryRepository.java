package com.example.phat_store_rest.modal.repositories;

import com.example.phat_store_rest.modal.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
