package com.karanjadavid.e_commerce_rest.cart.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartEditForm extends SessionUserIdForm {

    private String customerEntityId;

    private List<String> cartItemsEntityId;

}
