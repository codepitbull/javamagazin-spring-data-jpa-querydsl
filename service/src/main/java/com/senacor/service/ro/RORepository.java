package com.senacor.service.ro;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface RORepository<T, ID extends Serializable> extends Repository<T, ID> {
    T findOne(ID id);
	boolean exists(ID id);
	Iterable<T> findAll();
	Iterable<T> findAll(Iterable<ID> ids);
	long count();
}
