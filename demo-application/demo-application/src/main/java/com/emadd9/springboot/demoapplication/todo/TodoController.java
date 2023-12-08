package com.emadd9.springboot.demoapplication.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    private TodoService todoService;

    //list-todos
    @RequestMapping("list-todos")
    public String listAllTodoPage(ModelMap modalMap){
        List<Todo> todos = todoService.findByUsername("emadd9");
        modalMap.addAttribute("todos",todos);
        return "listTodos";
    }
    //add-todos
    @RequestMapping(value="add-todo",method=RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap){
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0,username,"", LocalDate.now().plusYears(1),false);
        modelMap.put("todo",todo);
        return "todo";
    }
    @RequestMapping(value="add-todo",method = RequestMethod.POST)
    public String addNewTodoPage(@Valid Todo todo, BindingResult result ,ModelMap modelMap) {
        if (result.hasErrors()) {

            return "todo";
        } else {

            String username = (String) modelMap.get("name");
            todoService.addNewTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
            return "redirect:list-todos";
        }
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value="update-todo",method=RequestMethod.GET)
    public String updateTodoPage(@RequestParam int id,ModelMap modelMap){
        String username = (String) modelMap.get("name");
        Todo todo = todoService.findById(id);
        modelMap.addAttribute("todo",todo);
        return "todo";
    }
    @RequestMapping(value="update-todo",method=RequestMethod.POST)
    public String listUpdateTodo(@Valid Todo todo,BindingResult result,ModelMap modelMap){
        if(result.hasErrors()){
            return "todo";
        }else {
            String username = (String) modelMap.get("name");
            todo.setUsername(username);
            todoService.updateTodo(todo);
            return "redirect:list-todos";
        }
    }
}
