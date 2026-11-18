package com.karanjadavid.e_commerce_rest.storebranch.service;

import com.karanjadavid.e_commerce_rest.lib.form.BaseFetchForm;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import com.karanjadavid.e_commerce_rest.storebranch.entity.StoreBranch;
import com.karanjadavid.e_commerce_rest.storebranch.repository.StoreBranchRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class StoreBranchReadService extends BaseJpaRepoReadService<StoreBranch, StoreBranchRepository> {

    public Page<StoreBranch> listStoreBranch(BaseFetchForm form){
        var spec = repository.notDeleted();

        return repository.findAll(
                spec,
                repository.defaultPageable(form)
        );
    }

}
