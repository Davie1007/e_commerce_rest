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
        category.setName(form.getName());
        category = save(category, form.getSessionUserId());
        return category;
    }

    public Category editCategory(String entityId, EditCategoryForm form){
        var category = findByEntityId(entityId);
        category.setName(form.getName());
        category = save(category, form.getSessionUserId());
        return category;
    }

    public void deleteCategory(String entityId){
        delete(entityId);
    }

}
