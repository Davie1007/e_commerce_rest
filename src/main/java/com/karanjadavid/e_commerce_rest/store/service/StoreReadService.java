package com.karanjadavid.e_commerce_rest.store.service;

import com.karanjadavid.e_commerce_rest.lib.form.BaseFetchForm;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import com.karanjadavid.e_commerce_rest.store.entity.Store;
import com.karanjadavid.e_commerce_rest.store.repository.StoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class StoreReadService extends BaseJpaRepoReadService<Store, StoreRepository> {

    public Page<Store> listStore(BaseFetchForm form){
        var spec = repository.notDeleted();

        return repository.findAll(
                spec,
                repository.defaultPageable(form)
        );
    }

}
