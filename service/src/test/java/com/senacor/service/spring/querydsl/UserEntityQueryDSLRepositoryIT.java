package com.senacor.service.spring.querydsl;

import com.senacor.domain.QUserEntity;
import com.senacor.domain.UserEntity;
import com.senacor.service.querydsl.UserEntityQueryDSLRepository;
import com.senacor.service.spring.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * @author Jochen Mader
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class UserEntityQueryDSLRepositoryIT {

    @Autowired
    private UserEntityQueryDSLRepository userEntityRepository;

    @Test
    public void testPredicate() {
        QUserEntity userEntity = QUserEntity.userEntity;
        Page<UserEntity> page =  userEntityRepository.findAll(userEntity.firstname.like("user%").and(userEntity.lastname.eq("user2")), new PageRequest(0,10));
        assertEquals(5, page.getNumberOfElements());
    }

    @Test
    public void testFindByFirstnameLikeAndLastnameEqualsComplex() {
        assertEquals(5, userEntityRepository.findByFirstnameLikeAndLastnameEquals("user%", "user2").size());
    }
}
