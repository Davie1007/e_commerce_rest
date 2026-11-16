package com.karanjadavid.e_commerce_rest.manufacturer.form;

import com.karanjadavid.e_commerce_rest.lib.entity.Address;
import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManufacturerEditForm extends SessionUserIdForm {

    private String name;

    private Address address;

}
