package com.karanjadavid.e_commerce_rest.product.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaEditService;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import com.karanjadavid.e_commerce_rest.product.form.EditProductForm;
import com.karanjadavid.e_commerce_rest.product.form.RegisterProductForm;
import com.karanjadavid.e_commerce_rest.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductEditService extends BaseJpaEditService<Product, ProductRepository> {

    public Product registerProduct(RegisterProductForm form){
        var product = new Product();
        product.setName(form.getName());
        return save(product, form.getSessionUserId());
    }

    public Product editProduct(String productID, EditProductForm form){
        var product = findByEntityId(productID);
        product.setName(form.getName());
        return save(product, form.getSessionUserId());
    }

    public void deleteProduct(String productId){
        delete(productId);
    }

}
