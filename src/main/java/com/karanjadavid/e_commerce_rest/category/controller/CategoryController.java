package com.karanjadavid.e_commerce_rest.category.controller;

import com.karanjadavid.e_commerce_rest.category.entity.Category;
import com.karanjadavid.e_commerce_rest.category.service.CategoryEditService;
import com.karanjadavid.e_commerce_rest.category.service.CategoryReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryEditService categoryEditService;
    private CategoryReadService categoryReadService;

    @GetMapping("/list")
    public ResponseEntity<List<Category>> getCategories(){
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<Category> registerCategory(){
        return null;
    }

    @DeleteMapping("/delete/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId){
        categoryEditService.delete(categoryId);
    }

    @Autowired
    public void setCategoryEditService(CategoryEditService service){
        this.categoryEditService = service;
    }

    @Autowired
    public void setCategoryReadService(CategoryReadService service){
        this.categoryReadService = service;
    }

}
