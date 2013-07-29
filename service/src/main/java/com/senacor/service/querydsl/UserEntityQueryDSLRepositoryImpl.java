package com.senacor.service.querydsl;

import com.mysema.query.jpa.impl.JPAQuery;
import com.senacor.domain.QUserEntity;
import com.senacor.domain.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Jochen Mader
 */
public class UserEntityQueryDSLRepositoryImpl implements UserEntityQueryDSLRepositoryExt{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserEntity> findByFirstnameLikeAndLastnameEquals(String firstname, String lastname) {
        JPAQuery query = new JPAQuery(em);
        QUserEntity qUserEntity = QUserEntity.userEntity;
        return query.from(qUserEntity).where(qUserEntity.firstname.like(firstname).and(qUserEntity.lastname.eq(lastname))).list(qUserEntity);
    }
}
