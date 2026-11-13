package com.karanjadavid.e_commerce_rest.inventory.controller;

import com.karanjadavid.e_commerce_rest.inventory.form.InventoryEditForm;
import com.karanjadavid.e_commerce_rest.inventory.form.InventoryRegistrationForm;
import com.karanjadavid.e_commerce_rest.inventory.service.InventoryEditService;
import com.karanjadavid.e_commerce_rest.inventory.view.InventoryView;
import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryEditService inventoryEditService;

    @PostMapping("/register/{productId}")
    public EntityApiResponse<InventoryView> registerInventory(@PathVariable String productId, @RequestBody InventoryRegistrationForm form, Locale locale){
        var inventory = inventoryEditService.registerInventory(form);
        return new EntityApiResponse<>(
                Message.get("inventory.registration.success", locale),
                new InventoryView(inventory)
        );
    }

    @PutMapping("/edit/{inventoryId}")
    public EntityApiResponse<InventoryView> editInventory(@PathVariable String inventoryId, @RequestBody InventoryEditForm form, Locale locale){
        var inventory = inventoryEditService.editInventory(inventoryId, form);
        return new EntityApiResponse<>(
                Message.get("inventory.edit.success", locale),
                new InventoryView(inventory)
        );
    }

    @Autowired
    public void setInventoryEditService(InventoryEditService service){
        this.inventoryEditService = service;
    }

}
