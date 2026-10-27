package com.karanjadavid.e_commerce_rest.product.controller;

import com.karanjadavid.e_commerce_rest.product.entity.Product;
import com.karanjadavid.e_commerce_rest.product.form.EditProductForm;
import com.karanjadavid.e_commerce_rest.product.form.RegisterProductForm;
import com.karanjadavid.e_commerce_rest.product.service.ProductEditService;
import com.karanjadavid.e_commerce_rest.product.service.ProductReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductEditService productEditService;
    private ProductReadService productReadService;

    @GetMapping("/list")
    public List<Product> getProducts(){
        return productReadService.getAllProducts();
    }

    @PostMapping("/register")
    public Product registerProduct(@RequestBody RegisterProductForm form){
        return productEditService.registerProduct(form);
    }

    @PutMapping("/edit/{productId}")
    public ResponseEntity<Product> editProduct(@PathVariable String productId, @RequestBody EditProductForm form) {
        var product = productEditService.editProduct(productId, form);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productEditService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }


    @Autowired
    public void setProductEditService(ProductEditService service){
        this.productEditService = service;
    }

    @Autowired
    public void setProductReadService(ProductReadService service){ this.productReadService = service; }

}