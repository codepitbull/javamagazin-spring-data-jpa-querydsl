package com.senacor.service.crud;

import com.senacor.domain.UserEntity;

import java.util.List;

/**
 * @author Jochen Mader
 */
public interface UserEntityRepositoryExt {
    List<UserEntity> findByFirstnameLikeAndLastnameEqualsComplex(String firstname, String lastname);
}
