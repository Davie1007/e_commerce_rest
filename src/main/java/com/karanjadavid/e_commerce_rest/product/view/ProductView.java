package com.karanjadavid.e_commerce_rest.product.view;

import com.karanjadavid.e_commerce_rest.lib.view.BaseView;
import com.karanjadavid.e_commerce_rest.product.entity.Product;

import java.util.List;

public class ProductView extends BaseView<Product> {
    public ProductView(Product entity) {
        super(entity);
    }

    public String getName(){ return entity.getName(); }

    public List<String> getImageUrls(){ return entity.getImageUrls(); }

}
