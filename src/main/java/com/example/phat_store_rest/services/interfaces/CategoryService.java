package com.example.phat_store_rest.services.interfaces;

import com.example.phat_store_rest.modal.entities.Category;
import com.example.phat_store_rest.services.DAO;

import java.util.List;

public interface CategoryService extends DAO<Category> {
    List<String> findAllNames();
}
