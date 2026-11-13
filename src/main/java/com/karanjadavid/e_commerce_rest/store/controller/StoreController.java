package com.karanjadavid.e_commerce_rest.store.controller;

import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import com.karanjadavid.e_commerce_rest.store.form.StoreEditForm;
import com.karanjadavid.e_commerce_rest.store.form.StoreRegistrationForm;
import com.karanjadavid.e_commerce_rest.store.service.StoreEditService;
import com.karanjadavid.e_commerce_rest.store.view.StoreView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/store")
public class StoreController {

    private StoreEditService storeEditService;

    @PostMapping("/register")
    public EntityApiResponse<StoreView> registerStore(@RequestBody StoreRegistrationForm form, Locale locale){
        var store = storeEditService.registerStore(form);
        return new EntityApiResponse<>(
                Message.get("store.registration.success", locale),
                new StoreView(store)
        );
    }

    @PutMapping("/edit/{storeId}")
    public EntityApiResponse<StoreView> editStore(@PathVariable String storeId, @RequestBody StoreEditForm form, Locale locale){
        var store = storeEditService.editStore(storeId, form);
        return new EntityApiResponse<>(
                Message.get("store.edit.success", locale),
                new StoreView(store)
        );
    }

    @Autowired
    public void setStoreEditService(StoreEditService service){
        this.storeEditService = service;
    }

}
