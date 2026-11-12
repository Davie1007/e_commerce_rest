package com.karanjadavid.e_commerce_rest.salesorder.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleOrderItemEditForm extends SessionUserIdForm {

    private String productEntityId;
    private int quantity;

}
