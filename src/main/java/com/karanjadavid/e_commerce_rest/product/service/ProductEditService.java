package com.karanjadavid.e_commerce_rest.product.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import com.karanjadavid.e_commerce_rest.product.form.EditProductForm;
import com.karanjadavid.e_commerce_rest.product.form.RegisterProductForm;
import com.karanjadavid.e_commerce_rest.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductEditService extends BaseJpaRepoEditService<Product, ProductRepository> {

    public Product registerProduct(RegisterProductForm form){
        var product = new Product();
        product.setName(form.getName());
        product =  save(product, form.getSessionUserId());
        return product;
    }

    public Product editProduct(String productID, EditProductForm form){
        var product = findByEntityId(productID);
        product.setName(form.getName());
        product = save(product, form.getSessionUserId());
        return product;
    }

    public void deleteProduct(String productId){
        delete(productId);
    }

}
