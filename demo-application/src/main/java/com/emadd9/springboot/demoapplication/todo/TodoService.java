package com.emadd9.springboot.demoapplication.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
  private static List<Todo> todos = new ArrayList();
  private static int todoCount=0;
  static {
      todos.add(new Todo(++todoCount,"emadd9","Learn AWS",
              LocalDate.now().plusYears(1),false));
      todos.add(new Todo(++todoCount,"emadd9","Learn DevOps",
              LocalDate.now().plusYears(1),false));
      todos.add(new Todo(++todoCount,"emadd9","Learn Java Full Stack",
              LocalDate.now().plusYears(1),false));
  }
  public List<Todo> findByUsername(String username){
      Predicate<? super Todo> predicate =
              todo -> todo.getUsername() == username;
      return todos.stream().filter(predicate).toList();
  }
  public void addNewTodo(String username,String description,
                         LocalDate targetDate, boolean done){
     todos.add(new Todo(++todoCount,username,description,targetDate,done));
  }

    public void deleteById(int id) {

        Predicate<? super Todo> predicate =
                todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate =
                todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
      deleteById(todo.getId());
      todos.add(todo);
    }
}
