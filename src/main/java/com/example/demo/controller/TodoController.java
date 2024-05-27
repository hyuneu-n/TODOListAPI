package com.example.demo.controller;

import com.example.demo.dto.TodoDto;
import com.example.demo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<TodoDto>> getTodosByMemberId(@PathVariable int memberId){
        List<TodoDto> todos = todoService.getTodosByMemberId(memberId);
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Void> createTodo(@RequestBody TodoDto todoDto){
        todoService.createTodo(todoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateTodoPartial(@PathVariable int id, @RequestBody TodoDto todoDto) {
        todoService.updateTodo(id, todoDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
