package com.example.phat_store_rest.services.implementations;

import com.example.phat_store_rest.modal.entities.Item;
import com.example.phat_store_rest.modal.repositories.ItemRepository;
import com.example.phat_store_rest.services.interfaces.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImplementation implements ItemService {
    private final ItemRepository repo;

    @Override
    public Item save(Item item) {
        return repo.save(item);
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Item> findAll() {
        return null;
    }
}
