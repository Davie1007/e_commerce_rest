package com.karanjadavid.e_commerce_rest.product.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.manufacturer.service.ManufacturerReadService;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import com.karanjadavid.e_commerce_rest.product.form.EditProductForm;
import com.karanjadavid.e_commerce_rest.product.form.RegisterProductForm;
import com.karanjadavid.e_commerce_rest.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductEditService extends BaseJpaRepoEditService<Product, ProductRepository> {

    private ManufacturerReadService manufacturerReadService;

    public Product registerProduct(RegisterProductForm form){
        var product = new Product();
        mapFields(product, form);
        product =  save(product, form.getSessionUserId());
        return product;
    }

    public Product editProduct(String productID, EditProductForm form){
        var product = findByEntityId(productID);
        mapFields(product, form);
        product = save(product, form.getSessionUserId());
        return product;
    }

    public void mapFields(Product product, EditProductForm form){
        var manufacturer = manufacturerReadService.findByEntityId(form.getManufacturerEntityId());
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        for(var imageUrl: form.getImageUrls()){
            product.getImageUrls().add(imageUrl);
        }
        product.setManufacturer(manufacturer);
    }

    public void deleteProduct(String productId){
        delete(productId);
    }

    @Autowired
    public void setManufacturerReadService(ManufacturerReadService service){
        this.manufacturerReadService = service;
    }

}
