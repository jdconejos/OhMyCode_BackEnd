package com.ohmycode.domain.repositories;

import com.ohmycode.domain.models.Todo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    @Query("select t from Todo t order by t.id")
    List<Todo> findWithPage(Pageable pageable);


}

