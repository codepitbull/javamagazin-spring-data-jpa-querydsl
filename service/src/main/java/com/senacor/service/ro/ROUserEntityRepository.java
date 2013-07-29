package com.senacor.service.ro;

import com.senacor.domain.UserEntity;
import com.senacor.service.crud.UserEntityRepositoryExt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Jochen Mader
 */
public interface ROUserEntityRepository extends RORepository<UserEntity, Long>{
}
