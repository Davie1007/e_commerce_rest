package com.karanjadavid.e_commerce_rest.category.form;

import com.karanjadavid.e_commerce_rest.category.entity.Category;
import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EditCategoryForm extends SessionUserIdForm {

    private String name;

    private List<String> imageUrls;

    private List<Category> subCategories;

}
