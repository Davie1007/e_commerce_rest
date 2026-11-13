package com.karanjadavid.e_commerce_rest.storebranch.view;

import com.karanjadavid.e_commerce_rest.inventory.entity.Inventory;
import com.karanjadavid.e_commerce_rest.lib.view.BaseView;
import com.karanjadavid.e_commerce_rest.storebranch.entity.StoreBranch;

import java.util.List;

public class StoreBranchView extends BaseView<StoreBranch> {
    public StoreBranchView(StoreBranch entity) {
        super(entity);
    }
    public String getName(){ return entity.getName(); }
    public List<Inventory> getInventories(){ return entity.getInventories(); }
    public String getImageUrl(){ return entity.getImageUrl(); }
}
