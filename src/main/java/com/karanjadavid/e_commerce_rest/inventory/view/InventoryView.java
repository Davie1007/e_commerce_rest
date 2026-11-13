package com.karanjadavid.e_commerce_rest.inventory.view;

import com.karanjadavid.e_commerce_rest.inventory.entity.Inventory;
import com.karanjadavid.e_commerce_rest.lib.view.BaseView;

public class InventoryView extends BaseView<Inventory> {
    public InventoryView(Inventory entity) {
        super(entity);
    }

    public String productName(){ return  entity.getProduct().getName(); }

    public int count(){ return entity.getCount(); }

}
