package com.karanjadavid.e_commerce_rest.product.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import com.karanjadavid.e_commerce_rest.product.entity.Product;
import com.karanjadavid.e_commerce_rest.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReadService extends BaseJpaRepoReadService<Product, ProductRepository> {

    public List<Product> getAllProducts(){

        return null;
    }

}
