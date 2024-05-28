package com.example.demo.service;

import com.example.demo.domain.Todo;
import com.example.demo.domain.Member;
import com.example.demo.dto.TodoDto;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    public TodoService(TodoRepository todoRepository, MemberRepository userRepository) {
        this.todoRepository = todoRepository;
        this.memberRepository = userRepository;
    }

    //read
    public List<TodoDto> getTodosByMemberId(int memberId){
        List<Todo> todos = todoRepository.findByMemberId(memberId);
        return todos.stream()
                .map(TodoDto::from)
                .collect(Collectors.toList());
    }

    //create
    public void createTodo(TodoDto todoDto) {
        Member member = memberRepository.findById(todoDto.getMemberId()).orElse(null);
        if (member == null)
            return;
        Todo todo = new Todo();
        todo.setMember(member);
        todo.setContent(todoDto.getContent());
        todo.setCompleted(todoDto.getCompleted());
        todoRepository.save(todo);
    }

    //update
    public void updateTodo(int id, TodoDto todoDto){
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null){
            if(todoDto.getContent()!=null)
                todo.setContent(todoDto.getContent());
            if(todoDto.getCompleted()!=null)
                todo.setCompleted(todoDto.getCompleted());
            todo.setCreated_at(LocalDateTime.now());
            todoRepository.save(todo);
        }
    }

    //delete
    public void deleteTodo(int id){
        todoRepository.deleteById(id);
    }
}
