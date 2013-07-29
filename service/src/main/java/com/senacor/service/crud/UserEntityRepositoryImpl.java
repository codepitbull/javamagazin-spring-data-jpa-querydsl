package com.senacor.service.crud;

import com.senacor.domain.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Jochen Mader
 */
public class UserEntityRepositoryImpl implements UserEntityRepositoryExt{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserEntity> findByFirstnameLikeAndLastnameEqualsComplex(String firstname, String lastname) {
        Query query = em.createQuery("select user from UserEntity user where user.firstname like :firstname% and user.lastname = :lastname");
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        return query.getResultList();
    }
}
