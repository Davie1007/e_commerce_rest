package com.karanjadavid.e_commerce_rest.inventory.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryEditForm extends SessionUserIdForm {

    private String productEntityId;

    private int count;

}
