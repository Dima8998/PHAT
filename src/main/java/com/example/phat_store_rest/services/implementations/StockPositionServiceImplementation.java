package com.example.phat_store_rest.services.implementations;

import com.example.phat_store_rest.modal.entities.StockPosition;
import com.example.phat_store_rest.modal.repositories.StockPositionRepository;
import com.example.phat_store_rest.services.interfaces.StockPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockPositionServiceImplementation implements StockPositionService {
    private final StockPositionRepository repo;

    @Override
    public StockPosition save(StockPosition stockPosition) {
        return repo.save(stockPosition);
    }

    @Override
    public Optional<StockPosition> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<StockPosition> findAll() {
        return null;
    }
}
