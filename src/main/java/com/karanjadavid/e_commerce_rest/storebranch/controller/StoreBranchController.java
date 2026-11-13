package com.karanjadavid.e_commerce_rest.storebranch.controller;

import com.karanjadavid.e_commerce_rest.lib.service.Message;
import com.karanjadavid.e_commerce_rest.lib.view.EntityApiResponse;
import com.karanjadavid.e_commerce_rest.storebranch.form.StoreBranchEditForm;
import com.karanjadavid.e_commerce_rest.storebranch.form.StoreBranchRegistrationForm;
import com.karanjadavid.e_commerce_rest.storebranch.service.StoreBranchEditService;
import com.karanjadavid.e_commerce_rest.storebranch.view.StoreBranchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/store-branch")
public class StoreBranchController {

    private StoreBranchEditService storeBranchEditService;

    @PostMapping("/register")
    public EntityApiResponse<StoreBranchView> registerStoreBranch(@RequestBody StoreBranchRegistrationForm form, Locale locale){
        var branch = storeBranchEditService.registerStoreBranch(form);
        return new EntityApiResponse<>(
                Message.get("store.branch.registration.success", locale),
                new StoreBranchView(branch)
        );
    }

    @PutMapping("/edit/{branchId}")
    public EntityApiResponse<StoreBranchView> editStoreBranch(@PathVariable String branchId, @RequestBody StoreBranchEditForm form, Locale locale){
        var branch = storeBranchEditService.editStoreBranch(branchId, form);
        return new EntityApiResponse<>(
                Message.get("store.branch.edit.success", locale),
                new StoreBranchView(branch)
        );
    }

    @Autowired
    public void setStoreBranchEditService(StoreBranchEditService service){
        this.storeBranchEditService = service;
    }

}
