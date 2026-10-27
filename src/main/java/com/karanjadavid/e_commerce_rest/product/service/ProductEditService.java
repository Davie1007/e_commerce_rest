package com.karanjadavid.e_commerce_rest.product.service;

import com.karanjadavid.e_commerce_rest.product.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class EditProductService {

    public Product registerProduct(){
        var product = new Product();
        product.setName("Looker");
        return product;
    }

    public Product editProduct(){
        var product = new Product("23e", "34");
        return product;
    }

    public void deleteProduct(){

    }

}
