package com.senacor.service.querydsl;

import com.senacor.domain.UserEntity;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jochen Mader
 */
public interface UserEntityQueryDSLRepository extends CrudRepository<UserEntity, Long>, QueryDslPredicateExecutor<UserEntity>, UserEntityQueryDSLRepositoryExt{
}
