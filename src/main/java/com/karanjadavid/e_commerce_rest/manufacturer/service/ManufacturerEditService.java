package com.karanjadavid.e_commerce_rest.manufacturer.service;

import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoEditService;
import com.karanjadavid.e_commerce_rest.manufacturer.entity.Manufacturer;
import com.karanjadavid.e_commerce_rest.manufacturer.form.ManufacturerEditForm;
import com.karanjadavid.e_commerce_rest.manufacturer.form.ManufacturerRegistrationForm;
import com.karanjadavid.e_commerce_rest.manufacturer.repository.ManufacturerRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class ManufacturerEditService extends BaseJpaRepoEditService<Manufacturer, ManufacturerRepository> {

    public Manufacturer registerManufacturer(ManufacturerRegistrationForm form){
        var manufacturer = new Manufacturer();
        mapFields(manufacturer, form);
        manufacturer = save(manufacturer, form.getSessionUserId());
        return manufacturer;
    }

    public Manufacturer editManufacturer(String manufacturerId, ManufacturerEditForm form){
        var manufacturer = findByEntityId(manufacturerId);
        mapFields(manufacturer, form);
        manufacturer = save(manufacturer, form.getSessionUserId());
        return manufacturer;
    }

    private void mapFields(Manufacturer manufacturer, ManufacturerEditForm form){
        manufacturer.setName(form.getName());
        manufacturer.setAddress(form.getAddress());
    }

}
