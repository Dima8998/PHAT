package com.example.phat_store_rest.services.implementations;

import com.example.phat_store_rest.modal.entities.Brand;
import com.example.phat_store_rest.modal.repositories.BrandRepository;
import com.example.phat_store_rest.services.interfaces.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BrandServiceImplementation implements BrandService {
    private final BrandRepository repo;

    @Override
    public Brand save(Brand transientBrand) {
        System.out.println(transientBrand);
        Brand persistentBrand = repo.save(transientBrand);
        System.out.println(persistentBrand);
        return persistentBrand;
    }

    @Override
    public Optional<Brand> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        return repo.findAll();
    }
}
