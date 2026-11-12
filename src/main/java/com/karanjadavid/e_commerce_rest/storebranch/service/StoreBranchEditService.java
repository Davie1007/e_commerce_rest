package com.karanjadavid.e_commerce_rest.storebranch.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.storebranch.entity.StoreBranch;
import com.karanjadavid.e_commerce_rest.storebranch.form.StoreBranchEditForm;
import com.karanjadavid.e_commerce_rest.storebranch.form.StoreBranchRegistrationForm;
import com.karanjadavid.e_commerce_rest.storebranch.repository.StoreBranchRepository;
import org.springframework.stereotype.Service;

@Service
public class StoreBranchEditService extends BaseJpaRepoEditService<StoreBranch, StoreBranchRepository> {

    public StoreBranch registerStoreBranch(StoreBranchRegistrationForm form){
        var storeBranch = new StoreBranch();
        mapFields(storeBranch, form);
        storeBranch = save(storeBranch, form.getSessionUserId());
        return storeBranch;
    }

    public StoreBranch editStoreBranch(String storeId, StoreBranchEditForm form){
        var storeBranch = findByEntityId(storeId);
        mapFields(storeBranch, form);
        storeBranch = save(storeBranch, form.getSessionUserId());
        return storeBranch;
    }

    private void mapFields(StoreBranch store, StoreBranchEditForm form){
        store.setName(form.getName());
        store.setImageUrl(form.getImageUrl());
    }

}
