package com.karanjadavid.e_commerce_rest.manufacturer.controller;

import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import com.karanjadavid.e_commerce_rest.manufacturer.form.ManufacturerEditForm;
import com.karanjadavid.e_commerce_rest.manufacturer.form.ManufacturerRegistrationForm;
import com.karanjadavid.e_commerce_rest.manufacturer.service.ManufacturerEditService;
import com.karanjadavid.e_commerce_rest.manufacturer.view.ManufacturerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private ManufacturerEditService manufacturerEditService;

    @PostMapping("/register")
    public EntityApiResponse<ManufacturerView> registerManufacturer(@RequestBody ManufacturerRegistrationForm form, Locale locale){
        var manufacturer = manufacturerEditService.registerManufacturer(form);
        return new EntityApiResponse<>(
                Message.get("manufacturer.registration.success", locale),
                new ManufacturerView(manufacturer)
        );
    }

    @PutMapping("/edit/{manufacturerId}")
    public EntityApiResponse<ManufacturerView> editManufacturer(@PathVariable String manufacturerId, @RequestBody ManufacturerEditForm form, Locale locale){
        var manufacturer = manufacturerEditService.editManufacturer(manufacturerId, form);
        return new EntityApiResponse<>(
                Message.get("manufacturer.edit.success", locale),
                new ManufacturerView(manufacturer)
        );
    }

    @Autowired
    public void setManufacturerEditService(ManufacturerEditService service){
        this.manufacturerEditService = service;
    }

}
