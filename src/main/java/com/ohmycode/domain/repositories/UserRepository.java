package com.ohmycode.domain.repositories;

import com.ohmycode.domain.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
