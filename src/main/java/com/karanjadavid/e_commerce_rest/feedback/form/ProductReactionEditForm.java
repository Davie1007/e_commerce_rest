package com.karanjadavid.e_commerce_rest.feedback.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import com.karanjadavid.e_commerce_rest.feedback.entity.ReactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReactionEditForm extends SessionUserIdForm {

    private String productEntityId;

    private String customerEntityId;

    private ReactionType reactionType;

}
