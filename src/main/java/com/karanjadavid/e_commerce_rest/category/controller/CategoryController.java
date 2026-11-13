package com.karanjadavid.e_commerce_rest.category.controller;

import com.karanjadavid.e_commerce_rest.category.entity.Category;
import com.karanjadavid.e_commerce_rest.category.form.EditCategoryForm;
import com.karanjadavid.e_commerce_rest.category.form.RegisterCategoryForm;
import com.karanjadavid.e_commerce_rest.category.service.CategoryEditService;
import com.karanjadavid.e_commerce_rest.category.service.CategoryReadService;
import com.karanjadavid.e_commerce_rest.category.view.CategoryView;
import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class CategoryController {

    private CategoryEditService categoryEditService;
    private CategoryReadService categoryReadService;

    @GetMapping("/list")
    public ResponseEntity<List<Category>> getCategories(){
        return null;
    }

    @PostMapping("/register")
    public EntityApiResponse<CategoryView> registerCategory(@RequestBody RegisterCategoryForm form, Locale locale){
        var category = categoryEditService.registerCategory(form);
        return new EntityApiResponse<>(
                Message.get("category.registration.success", locale),
                new CategoryView(category)
        );
    }

    @PutMapping("/edit/{categoryId}")
    public EntityApiResponse<CategoryView> editCategory(@PathVariable String categoryId, @RequestBody EditCategoryForm form, Locale locale){
        var category = categoryEditService.editCategory(categoryId, form);
        return new EntityApiResponse<>(
                Message.get("category.registration.success", locale),
                new CategoryView(category)
        );
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
