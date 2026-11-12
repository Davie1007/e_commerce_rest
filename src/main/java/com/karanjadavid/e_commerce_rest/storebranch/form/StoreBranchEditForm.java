package com.karanjadavid.e_commerce_rest.storebranch.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreBranchEditForm extends SessionUserIdForm {

    private String name;
    private String imageUrl;

}
