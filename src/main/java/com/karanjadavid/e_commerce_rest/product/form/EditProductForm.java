package com.karanjadavid.e_commerce_rest.product.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class EditProductForm extends SessionUserIdForm {

    private String name;

    private BigDecimal price;

    private List<String> imageUrls;

    private Map<String, String> features = new HashMap<>();

    private String manufacturerEntityId;

}
