package com.karanjadavid.e_commerce_rest.lib.service;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public abstract class BaseJpaEditService<T extends BaseJpaEntity, R extends BaseJpaRepository<T>> extends BaseJpaReadService<T, R> {

    public List<T> save(List<T> models, String updatedBy){
        for(var model: models){
            model.setCreatedByEntityId(updatedBy);
            model.setCreatedAt(LocalDateTime.now());
            model.setUpdatedByEntityId(updatedBy);
            model.setUpdatedAt(LocalDateTime.now());
        }
        return repository.saveAll(models);
    }

    public T save(T model, String updatedBy){
        model.setCreatedByEntityId(updatedBy);
        model.setCreatedAt(LocalDateTime.now());
        model.setDeletedByEntityId(updatedBy);
        model.setUpdatedAt(LocalDateTime.now());
        return repository.save(model);
    }

    public void delete(String entityId) {
        T model = findByEntityId(entityId);

    }

    public void delete(List<String> entityIds){
        for(var entityId: entityIds){
            delete(entityId);
        }
    }

}
