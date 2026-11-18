package com.karanjadavid.e_commerce_rest.salesorder.service;

import com.karanjadavid.e_commerce_rest.lib.form.BaseFetchForm;
import com.karanjadavid.e_commerce_rest.lib.service.BaseJpaRepoReadService;
import com.karanjadavid.e_commerce_rest.salesorder.entity.SalesOrder;
import com.karanjadavid.e_commerce_rest.salesorder.repository.SalesOrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderReadService extends BaseJpaRepoReadService<SalesOrder, SalesOrderRepository> {

    public Page<SalesOrder> listSalesOrder(BaseFetchForm form){
        var spec = repository.notDeleted();

        return repository.findAll(
                spec,
                repository.defaultPageable(form)
        );
    }

}
