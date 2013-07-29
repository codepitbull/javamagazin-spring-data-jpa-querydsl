package com.senacor.service.spring.ro;

import com.senacor.domain.UserEntity;
import com.senacor.service.crud.UserEntityRepository;
import com.senacor.service.ro.ROUserEntityRepository;
import com.senacor.service.spring.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Jochen Mader
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class ROUserEntityRepositoryIT {

    @Autowired
    private ROUserEntityRepository roUserEntityRepository;

    @Test
    public void testFindOne() {
        assertNotNull(roUserEntityRepository.findOne(1l));
    }
}
