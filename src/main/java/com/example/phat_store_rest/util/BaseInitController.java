package com.example.phat_store_rest.util;

import com.example.phat_store_rest.modal.entities.Brand;
import com.example.phat_store_rest.modal.entities.Category;
import com.example.phat_store_rest.services.interfaces.BrandService;
import com.example.phat_store_rest.services.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/init")
@RequiredArgsConstructor
public class BaseInitController {
    private final CategoryService categoryService;
    private final BrandService brandService;

    @GetMapping
    public void tableInit() {
        categoriesInit();
        brandsInit();
    }


    private void categoriesInit() {
        List.of("ГОЛОВНЫЕ УБОРЫ", "ОДЕЖДА", "ОБУВЬ", "СУМКИ", "АКСЕССУАРЫ", "ТВОРЧЕСТВО")
                .forEach(name -> {
                    Category transientCategory = new Category(name);
                    categoryService.save(transientCategory);
                });
    }

    public void brandsInit() {
        List.of("Kangol", "ProClub", "Novesta", "PHAT")
                .forEach(name -> {
                    Brand transientBrand = new Brand(name);
                    brandService.save(transientBrand);
                });
    }
}