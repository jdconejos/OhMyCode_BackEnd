package com.ohmycode.domain.controllers;

import com.ohmycode.domain.models.Todo;
import com.ohmycode.domain.models.UserDao;
import com.ohmycode.domain.repositories.TodoRepository;
import com.ohmycode.domain.repositories.UserRepository;
import com.ohmycode.rest.DTOs.DTOAddress;
import com.ohmycode.rest.DTOs.DTOTodo;
import com.ohmycode.rest.DTOs.DTOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<DTOTodo> getAllTodos() {
        List<DTOTodo> dtoTodoList = new ArrayList<>();
        List<Todo> todoList = todoRepository.findAllOrdered();

        for(Todo todo : todoList) {
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

    public void createTodo(String title, Boolean completed, Long userId) {

        Optional<UserDao> user = userRepository.findById(userId);
        if(!user.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Todo newTodo = new Todo();
        newTodo.setTitle(title);
        newTodo.setCompleted(completed);
        newTodo.setUser(user.get());

        todoRepository.save(newTodo);

    }

    public void editTodo(Long todoId, String title, Boolean completed, Long userId) {
        Optional<UserDao> user = userRepository.findById(userId);
        Optional<Todo> todo = todoRepository.findById(todoId);

        if(!user.isPresent() || !todo.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Todo editTodo = todo.get();
        editTodo.setTitle(title);
        editTodo.setCompleted(completed);
        editTodo.setUser(user.get());

        todoRepository.save(editTodo);
    }

    public void deleteTodo(Long id) {
        try {
            todoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
