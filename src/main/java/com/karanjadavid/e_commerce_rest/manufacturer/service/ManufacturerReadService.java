package com.karanjadavid.e_commerce_rest.manufacturer.service;

import com.karanjadavid.e_commerce_rest.lib.form.BaseFetchForm;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import com.karanjadavid.e_commerce_rest.manufacturer.entity.Manufacturer;
import com.karanjadavid.e_commerce_rest.manufacturer.repository.ManufacturerRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerReadService extends BaseJpaRepoReadService<Manufacturer, ManufacturerRepository> {

    public Page<Manufacturer> listManufacturer(BaseFetchForm form){
        var spec = repository.notDeleted();

        return repository.findAll(
                spec,
                repository.defaultPageable(form)
        );
    }

}
