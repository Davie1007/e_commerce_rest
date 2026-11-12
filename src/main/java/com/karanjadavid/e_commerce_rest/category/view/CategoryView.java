package com.karanjadavid.e_commerce_rest.category.view;

import com.karanjadavid.e_commerce_rest.category.entity.Category;
import com.karanjadavid.e_commerce_rest.lib.view.BaseView;

import java.util.List;

public class CategoryView extends BaseView<Category> {
    public CategoryView(Category entity) {
        super(entity);
    }

    public String getName(){ return entity.getName(); }
    public List<String> getImageUrls(){ return entity.getImageUrls(); }
    public Category getParent(){ return entity.getParent(); }
    public List<Category> subCategories(){ return entity.getSubCategories(); }
}
