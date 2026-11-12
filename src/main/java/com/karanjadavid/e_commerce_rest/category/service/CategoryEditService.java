package com.karanjadavid.e_commerce_rest.category.service;

import com.karanjadavid.e_commerce_rest.category.entity.Category;
import com.karanjadavid.e_commerce_rest.category.form.EditCategoryForm;
import com.karanjadavid.e_commerce_rest.category.form.RegisterCategoryForm;
import com.karanjadavid.e_commerce_rest.category.repository.CategoryRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import org.springframework.stereotype.Service;

@Service
public class CategoryEditService extends BaseJpaRepoEditService<Category, CategoryRepository> {

    public Category registerCategory(RegisterCategoryForm form){
        var category = new Category();
        mapFields(category, form);
        category = save(category, form.getSessionUserId());
        return category;
    }

    public Category editCategory(String entityId, EditCategoryForm form){
        var category = findByEntityId(entityId);
        mapFields(category, form);
        category = save(category, form.getSessionUserId());
        return category;
    }

    private void mapFields(Category category, EditCategoryForm form){
        category.setName(form.getName());
        for(var imageUrl: form.getImageUrls()){
            category.getImageUrls().add(imageUrl);
        }
        for(var subCategory: form.getSubCategories()){
            category.addSubcategory(subCategory);
        }
    }

    public void deleteCategory(String entityId){
        delete(entityId);
    }

}
