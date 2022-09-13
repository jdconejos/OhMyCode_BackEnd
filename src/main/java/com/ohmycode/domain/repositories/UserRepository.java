package com.ohmycode.domain.repositories;

import com.ohmycode.domain.models.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Long> {
    UserDao findByUsername(String username);
}
