package com.senacor.service.querydsl;

import com.senacor.domain.UserEntity;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Jochen Mader
 */
public interface UserEntityQueryDSLRepositoryExt {
    List<UserEntity> findByFirstnameLikeAndLastnameEquals(String firstname, String lastname);
}
