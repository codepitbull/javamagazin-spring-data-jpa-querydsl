package com.senacor.service.spring.crud;

import com.senacor.domain.UserEntity;
import com.senacor.service.crud.UserEntityRepository;
import com.senacor.service.spring.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Jochen Mader
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class UserEntityRepositoryIT {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Test
    public void testFindByFirstnameLikeAndLastnameEquals() {
        List<UserEntity> userEntities = userEntityRepository.findByFirstnameLikeAndLastnameEquals("user%", "user2");
        assertEquals(5, userEntities.size());
    }

    @Test
    public void testFindByFirstnameLikeAndLastnameEqualsAnnotated() {
        List<UserEntity> userEntities = userEntityRepository.findByFirstnameLikeAndLastnameEqualsAnnotated("user", "user2");
        assertEquals(5, userEntities.size());
    }

    @Test
    public void testFindByFirstnameLikeAndLastnameEqualsComplex() {
        List<UserEntity> userEntities = userEntityRepository.findByFirstnameLikeAndLastnameEqualsAnnotated("user", "user2");
        assertEquals(5, userEntities.size());
    }
}
