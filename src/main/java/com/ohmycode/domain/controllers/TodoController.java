package com.ohmycode.domain.controllers;

import com.ohmycode.domain.models.Todo;
import com.ohmycode.domain.repositories.TodoRepository;
import com.ohmycode.domain.repositories.UserRepository;
import com.ohmycode.rest.DTOs.DTOAddress;
import com.ohmycode.rest.DTOs.DTOTodo;
import com.ohmycode.rest.DTOs.DTOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    public List<DTOTodo> getAllTodos() {
        List<DTOTodo> dtoTodoList = new ArrayList<>();
        Iterable<Todo> todoIterable = todoRepository.findAll();

        for(Todo todo : todoIterable) {
            DTOAddress newDTOAddress = new DTOAddress(todo.getUser().getAddress().getId(), todo.getUser().getAddress().getStreet(), todo.getUser().getAddress().getCity(), todo.getUser().getAddress().getZipcode(), todo.getUser().getAddress().getCountry());
            DTOUser newDTOUser = new DTOUser(todo.getUser().getId(), todo.getUser().getName(), todo.getUser().getUsername(), newDTOAddress);
            DTOTodo newDTOTodo = new DTOTodo(newDTOUser, todo.getId(), todo.getTitle(), todo.getCompleted());

            dtoTodoList.add(newDTOTodo);
        }
        return dtoTodoList;
    }

    public List<DTOTodo> getTodosWithPage(int pageNumber, int pageLength) {

        Pageable page = PageRequest.of(pageNumber, pageLength);

        List<DTOTodo> dtoTodoList = new ArrayList<>();
        Iterable<Todo> todoIterable = todoRepository.findWithPage(page);

        for(Todo todo : todoIterable) {
            DTOAddress newDTOAddress = new DTOAddress(todo.getUser().getAddress().getId(), todo.getUser().getAddress().getStreet(), todo.getUser().getAddress().getCity(), todo.getUser().getAddress().getZipcode(), todo.getUser().getAddress().getCountry());
            DTOUser newDTOUser = new DTOUser(todo.getUser().getId(), todo.getUser().getName(), todo.getUser().getUsername(), newDTOAddress);
            DTOTodo newDTOTodo = new DTOTodo(newDTOUser, todo.getId(), todo.getTitle(), todo.getCompleted());

            dtoTodoList.add(newDTOTodo);
        }
        return dtoTodoList;

    }
}
