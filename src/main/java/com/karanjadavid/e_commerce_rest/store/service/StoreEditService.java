package com.karanjadavid.e_commerce_rest.store.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.store.entity.Store;
import com.karanjadavid.e_commerce_rest.store.form.StoreRegistrationForm;
import com.karanjadavid.e_commerce_rest.store.repository.StoreRepository;
import com.karanjadavid.e_commerce_rest.storebranch.form.StoreBranchEditForm;
import org.springframework.stereotype.Service;

@Service
public class StoreEditService extends BaseJpaRepoEditService<Store, StoreRepository> {

    public Store registerStore(StoreRegistrationForm form){
        var store = new Store();
        store.setName(form.getName());
        store = save(store, form.getSessionUserId());
        return store;
    }

    public Store editStore(String storeId, StoreBranchEditForm form){
        var store = findByEntityId(storeId);
        store.setName(form.getName());
        store = save(store, form.getSessionUserId());
        return store;
    }

}
