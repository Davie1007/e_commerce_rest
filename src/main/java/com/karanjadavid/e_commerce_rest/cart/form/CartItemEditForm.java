package com.karanjadavid.e_commerce_rest.cart.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemEditForm extends SessionUserIdForm {

    private String productEntityId;

    private int quantity;

}
