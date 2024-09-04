package com.example.phat_store_rest.util;

import com.example.phat_store_rest.modal.entities.Brand;
import com.example.phat_store_rest.modal.entities.Category;
import com.example.phat_store_rest.modal.entities.Item;
import com.example.phat_store_rest.modal.entities.StockPosition;
import com.example.phat_store_rest.modal.entities.enumAttributes.Color;
import com.example.phat_store_rest.modal.entities.enumAttributes.Sex;
import com.example.phat_store_rest.modal.entities.enumAttributes.Size;
import com.example.phat_store_rest.services.interfaces.BrandService;
import com.example.phat_store_rest.services.interfaces.CategoryService;
import com.example.phat_store_rest.services.interfaces.ItemService;
import com.example.phat_store_rest.services.interfaces.StockPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@RestController
@RequestMapping("/init")
@RequiredArgsConstructor
public class BaseInitController {
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final ItemService itemService;
    private final StockPositionService stockPositionService;

    private Brand tempBrand;
    private Category tempCategory;
    private Item tempItem;

    @GetMapping
    public void tableInit() throws IOException {
        categoriesInit();
        brandsInit();
        allItemsInit();
    }


    private void categoriesInit() {
        List.of("ГОЛОВНЫЕ УБОРЫ", "ОДЕЖДА", "ОБУВЬ", "СУМКИ", "АКСЕССУАРЫ", "ТВОРЧЕСТВО")
                .forEach(name -> {
                    Category transientCategory = Category.builder()
                            .name(name)
                            .catalogue(new HashSet<>())
                            .build();
                    categoryService.save(transientCategory);
                });
    }

    public void brandsInit() {
        List.of("Kangol", "ProClub", "Novesta", "PHAT")
                .forEach(name -> {
                    Brand transientBrand = Brand.builder()
                            .name(name)
                            .catalogue(new HashSet<>())
                            .build();
                    brandService.save(transientBrand);
                });
    }

    private void allItemsInit() throws IOException {
        String itemsFile = "items.txt";

        try (Stream<String> stream = Files.lines(Path.of(itemsFile))) {
            List<String> strings = stream.toList();

            tempCategory = categoryService.findById(1).get();
            tempBrand = brandService.findById(1).get();

            for (int i = 0; i < strings.size(); i++) {
                if (i < 15) saveHatModel(strings.get(i));
                if (i == 15){
                    tempCategory = categoryService.findById(2).get();
                    tempBrand = brandService.findById(2).get();
                }
                if (i == 30){
                    tempCategory = categoryService.findById(3).get();
                    tempBrand = brandService.findById(3).get();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveHatModel(String modelDescription) {
        String[] modelsProps = modelDescription
                .substring(1, modelDescription.length() - 2)
                .split(", ");

        // TODO: посмотреть паттерн builder
        tempItem = Item.builder()
                .article(String.valueOf(new Random().nextInt(1_000_000, 10_000_000)))
                .model(modelsProps[2])
                .price(Double.parseDouble(modelsProps[3]))
                .brand(tempBrand)
                .category(tempCategory)
                .sex(Sex.UNISEX)
                .stock(new HashSet<>())
                .build();

        tempBrand.getCatalogue().add(tempItem);
        tempCategory.getCatalogue().add(tempItem);
        // TODO: проверить, сохраняются ли связи

        itemService.save(tempItem);

        saveHatModelStockPositions();

        itemService.save(tempItem);
    }

    private void saveHatModelStockPositions() {
        Arrays.stream(Color.values())
                .forEach(color -> {
                    saveSPByColorAndSize(color);
                });
    }

    private void saveSPByColorAndSize(Color color) {
        Size.HATS.getSizes()
                .forEach(size -> {
                    StockPosition transientStockPosition = StockPosition.builder()
                            .item(tempItem)
                            .color(color)
                            .size(size)
                            .amount(new Random().nextInt(0, 10))
                            .build();
                    tempItem.getStock().add(transientStockPosition);
                    stockPositionService.save(transientStockPosition);
                });
    }
}