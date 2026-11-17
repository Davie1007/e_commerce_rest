package com.karanjadavid.e_commerce_rest.review.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewEditForm extends SessionUserIdForm {

    private String productEntityId;

    private String customerEntityId;

    private String text;

}
