package com.example.phat_store_rest.controller;

import com.example.phat_store_rest.services.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class IndexController {
    private final CategoryService categoryService;
    @GetMapping("index")
    public List<String> home() {
        return categoryService.findAllNames();
    }
}
