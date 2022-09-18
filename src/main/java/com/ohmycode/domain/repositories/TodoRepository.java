package com.ohmycode.domain.repositories;

import com.ohmycode.domain.models.Todo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Query("select t from Todo t where t.userDao.username = ?1 order by t.id")
    List<Todo> findByUserDao_UsernameOrderByIdAsc(String username);

    @Query("select t from Todo t where t.userDao.username = ?1 order by t.id")
    List<Todo> findByUserDao_UsernameWithPageOrderByIdAsc(Pageable pageable, String username);

    @Query("select t from Todo t order by t.id")
    List<Todo> findWithPage(Pageable pageable);

    @Query("select t from Todo t order by t.id")
    List<Todo> findAllOrdered();




}

