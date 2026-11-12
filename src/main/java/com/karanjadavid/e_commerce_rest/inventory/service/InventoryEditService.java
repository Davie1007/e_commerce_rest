package com.karanjadavid.e_commerce_rest.inventory.service;

import com.karanjadavid.e_commerce_rest.inventory.entity.Inventory;
import com.karanjadavid.e_commerce_rest.inventory.form.InventoryEditForm;
import com.karanjadavid.e_commerce_rest.inventory.form.InventoryRegistrationForm;
import com.karanjadavid.e_commerce_rest.inventory.repository.InventoryRepository;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.product.service.ProductEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryEditService extends BaseJpaRepoEditService<Inventory, InventoryRepository> {

    private ProductEditService productEditService;

    public Inventory registerInventory(InventoryRegistrationForm form){
        var inventory = new Inventory();
        mapFields(inventory, form);
        return inventory;
    }

    public Inventory editInventory(String inventoryId, InventoryEditForm form){
        var inventory = findByEntityId(inventoryId);
        mapFields(inventory, form);
        return inventory;
    }

    private void mapFields(Inventory inventory, InventoryEditForm form){
        var product = productEditService.findByEntityId(form.getProductEntityId());
        inventory.setProduct(product);
        inventory.setCount(form.getCount());
    }

    @Autowired
    public void setProductEditService(ProductEditService service){
        this.productEditService = service;
    }

}
