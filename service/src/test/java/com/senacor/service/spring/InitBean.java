package com.senacor.service.spring;

import com.senacor.domain.UserEntity;
import com.senacor.service.crud.UserEntityRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jochen Mader
 */
@Component
public class InitBean implements InitializingBean {
    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<UserEntity> entities = new ArrayList<UserEntity>();
        for (long count = 0; count < 5; count++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(count);
            userEntity.setBirthday(DateTime.now().toDateMidnight().toDate());
            userEntity.setFirstname("user1");
            userEntity.setLastname("user2");
            entities.add(userEntity);
        }
        userEntityRepository.save(entities);
    }
}
