package com.senacor.service.crud;

import com.senacor.domain.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Jochen Mader
 */
public interface UserEntityRepository extends CrudRepository<UserEntity, Long>, UserEntityRepositoryExt{
    @Query("select user from UserEntity user where user.firstname like :firstname% and user.lastname = :lastname")
    List<UserEntity> findByFirstnameLikeAndLastnameEqualsAnnotated(@Param("firstname") String firstname, @Param("lastname") String lastname);

    List<UserEntity> findByFirstnameLikeAndLastnameEquals(String lastname, String firstname);

}
