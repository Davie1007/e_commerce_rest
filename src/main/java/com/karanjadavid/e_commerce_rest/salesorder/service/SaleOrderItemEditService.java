package com.karanjadavid.e_commerce_rest.salesorder.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.product.service.ProductReadService;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SaleOrderItem;
import com.karanjadavid.e_commerce_rest.salesorder.form.SaleOrderItemEditForm;
import com.karanjadavid.e_commerce_rest.salesorder.form.SaleOrderItemRegistrationForm;
import com.karanjadavid.e_commerce_rest.salesorder.repository.SalesOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderItemEditService extends BaseJpaRepoEditService<SaleOrderItem, SalesOrderItemRepository> {

    private ProductReadService productReadService;

    public SaleOrderItem registerSaleOrderItem(SaleOrderItemRegistrationForm form){
        var item = new SaleOrderItem();
        mapFields(item, form);
        return item;
    }

    public SaleOrderItem editSaleOrderItem(String itemId, SaleOrderItemEditForm form){
        var item = findByEntityId(itemId);
        mapFields(item, form);
        return item;
    }

    private void mapFields(SaleOrderItem item, SaleOrderItemEditForm form){
        var product = productReadService.findByEntityId(form.getProductEntityId());
        item.setProduct(product);
        item.setQuantity(form.getQuantity());
    }

    @Autowired
    public void setProductReadService(ProductReadService service){
        this.productReadService = service;
    }

}
