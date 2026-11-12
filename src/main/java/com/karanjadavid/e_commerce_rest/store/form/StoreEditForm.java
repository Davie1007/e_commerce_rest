package com.karanjadavid.e_commerce_rest.store.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreEditForm extends SessionUserIdForm {

    private String name;

    private String imageUrl;

}
