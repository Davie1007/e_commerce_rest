package com.karanjadavid.e_commerce_rest.product.controller;

import com.karanjadavid.e_commerce_rest.lib.form.BaseFetchForm;
import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import com.karanjadavid.e_commerce_rest.lib.view.PagedEntityApiResponse;
import com.karanjadavid.e_commerce_rest.product.form.EditProductForm;
import com.karanjadavid.e_commerce_rest.product.form.RegisterProductForm;
import com.karanjadavid.e_commerce_rest.product.service.ProductEditService;
import com.karanjadavid.e_commerce_rest.product.service.ProductReadService;
import com.karanjadavid.e_commerce_rest.product.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductEditService productEditService;
    private ProductReadService productReadService;

    @GetMapping("list")
    public PagedEntityApiResponse<ProductView> list(
            @RequestParam(name="query", required = false)String query,
            @RequestParam(name="pageNum", required = false, defaultValue = "0") Integer pageNum,
            @RequestParam(name="pageSize", required = false, defaultValue = "100") Integer pageSize
    ){
        var form = new BaseFetchForm();
        form.setQuery(query);
        form.setPageNum(pageNum);
        form.setPageSize(pageSize);

        var page = productReadService.listProducts(form);
        var views = page.getContent().stream().map(ProductView::new).toList();
        return new PagedEntityApiResponse<>(page, views);
    }

    @PostMapping("/register")
    public EntityApiResponse<ProductView> registerProduct(@RequestBody RegisterProductForm form, Locale locale){
        var product = productEditService.registerProduct(form);
        return new EntityApiResponse<>(
                Message.get("product.registration.success", locale),
                new ProductView(product)
        );
    }

    @PutMapping("/edit/{productId}")
    public EntityApiResponse<ProductView> editProduct(@PathVariable String productId, @RequestBody EditProductForm form, Locale locale) {
        var product = productEditService.editProduct(productId, form);
        return new EntityApiResponse<>(
                Message.get("product.edit.success", locale),
                new ProductView(product)
        );
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