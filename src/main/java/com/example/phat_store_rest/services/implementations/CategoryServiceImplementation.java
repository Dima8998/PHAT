package com.example.phat_store_rest.services.implementations;

import com.example.phat_store_rest.modal.entities.Category;
import com.example.phat_store_rest.modal.repositories.CategoryRepository;
import com.example.phat_store_rest.services.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImplementation implements CategoryService {
    private final CategoryRepository repo;
    @Override
    public Category save(Category transientCategory) {
        System.out.println(transientCategory);
        Category persistentCategory = repo.save(transientCategory);
        System.out.println(persistentCategory);
        return persistentCategory;
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public List<String> findAllNames() {
        List<String> categories = repo.findAll()
                .stream()
                .map(category -> category.getName())
                .toList();
        return categories;
    }
}
