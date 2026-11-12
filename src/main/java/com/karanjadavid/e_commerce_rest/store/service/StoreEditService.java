package com.karanjadavid.e_commerce_rest.store.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.store.entity.Store;
import com.karanjadavid.e_commerce_rest.store.form.StoreEditForm;
import com.karanjadavid.e_commerce_rest.store.form.StoreRegistrationForm;
import com.karanjadavid.e_commerce_rest.store.repository.StoreRepository;
import org.springframework.stereotype.Service;

@Service
public class StoreEditService extends BaseJpaRepoEditService<Store, StoreRepository> {

    public Store registerStore(StoreRegistrationForm form){
        var store = new Store();
        mapFields(store, form);
        store = save(store, form.getSessionUserId());
        return store;
    }

    public Store editStore(String storeId, StoreEditForm form){
        var store = findByEntityId(storeId);
        mapFields(store, form);
        store = save(store, form.getSessionUserId());
        return store;
    }

    private void mapFields(Store store, StoreEditForm form){
        store.setName(form.getName());
        store.setImageUrl(form.getImageUrl());
    }

}
