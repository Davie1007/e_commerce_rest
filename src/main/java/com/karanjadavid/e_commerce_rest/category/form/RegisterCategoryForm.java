package com.karanjadavid.e_commerce_rest.category.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCategoryForm extends SessionUserIdForm {

    private String name;

}
