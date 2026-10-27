package com.karanjadavid.e_commerce_rest.lib.service;

import com.karanjadavid.e_commerce_rest.lib.entity.BaseJpaEntity;
import com.karanjadavid.e_commerce_rest.lib.exception.CommonRuntimeException;
import com.karanjadavid.e_commerce_rest.lib.exception.ExceptionType;
import com.karanjadavid.e_commerce_rest.lib.repository.BaseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public abstract class BaseJpaReadService<T extends BaseJpaEntity, R extends BaseJpaRepository<T>> {

    protected R repository;

    public T findByEntityId(String entityId) {
        Optional<T> opt = repository.findByEntityIdAndDeletedAtIsNull(entityId);
        if (opt.isEmpty()) {
            throw new CommonRuntimeException(
                    ExceptionType.NOT_FOUND,
                    "error.entity.not.found"
            );
        }
        return opt.get();
    }

    public boolean existsByEntityId(String entityId) {
        Specification<T> spec = repository.notDeleted()
                .and(repository.entityIdIs(entityId));
        return repository.exists(spec);
    }

    public T findByEntityIdIncludeDeleted(String entityId) {
        Optional<T> opt = repository.findByEntityId(entityId);
        if (opt.isEmpty()) {
            throw new CommonRuntimeException(
                    ExceptionType.NOT_FOUND,
                    "error.entity.not.found"
            );
        }
        return opt.get();
    }

    public List<T> findAll() {
        Specification<T> spec = repository.notDeleted();
        return repository.findAll(spec);
    }

    public List<T> findByIds(List<String> entityIds) {
        Specification<T> spec = repository.notDeleted()
                .and(repository.entityIdIn(entityIds));
        return repository.findAll(spec);
    }

    @Autowired
    public void setRepository(R repository){
        this.repository = repository;
    }

}
