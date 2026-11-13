package com.karanjadavid.e_commerce_rest.store.view;

import com.karanjadavid.e_commerce_rest.lib.view.BaseView;
import com.karanjadavid.e_commerce_rest.store.entity.Store;
import com.karanjadavid.e_commerce_rest.storebranch.entity.StoreBranch;

import java.util.List;

public class StoreView extends BaseView<Store> {
    public StoreView(Store entity) {
        super(entity);
    }

    public String getName(){ return entity.getName(); }

    public String getLogoImageUrl(){ return entity.getLogoUrl(); }

    public List<StoreBranch> getStoreBranches(){ return entity.getBranches(); }

    public String getImageUrl(){ return entity.getImageUrl(); }

    public List<String> getBannerImageUrls(){ return entity.getBannerImagesUrls(); }

}
