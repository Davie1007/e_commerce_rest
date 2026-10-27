package com.karanjadavid.e_commerce_rest.lib.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseView<T extends BaseJpaEntity> {
    protected T entity;

    public BaseView(T entity) {
        this.entity = entity;
    }

    public String getId(){
        return entity.getEntityId();
    }

    public LocalDateTime getCreatedAt(){
        return entity.getCreatedAt();
    }

    public LocalDateTime getUpdatedAt(){
        return entity.getUpdatedAt();
    }

    public boolean getIsDeleted(){
        return entity.getIsDeleted();
    }
}
