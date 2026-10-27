package com.karanjadavid.e_commerce_rest.product.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditProductForm extends SessionUserIdForm {

    String name;

}
