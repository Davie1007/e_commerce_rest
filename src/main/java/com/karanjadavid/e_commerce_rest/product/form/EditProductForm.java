package com.karanjadavid.e_commerce_rest.product.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EditProductForm extends SessionUserIdForm {

    private String name;

    private List<String> imageUrls;

}
