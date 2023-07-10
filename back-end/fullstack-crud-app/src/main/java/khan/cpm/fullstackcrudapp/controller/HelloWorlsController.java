package khan.cpm.fullstackcrudapp.controller;

import khan.cpm.fullstackcrudapp.HelloWorldBean;
import khan.cpm.fullstackcrudapp.Todo;
import khan.cpm.fullstackcrudapp.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorlsController {


    private TodoService todoService;

    public HelloWorlsController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "todo/{username}")
    public List<Todo> findByIdTodos(@PathVariable String username){
       return todoService.findByUsername(username);
    }
    public  String helloWorld(){
        return  "Hello World";
    }
    @GetMapping("/hello-bean")
    public HelloWorldBean helloWorldBean(){
        return  new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/name/{name}")
    public HelloWorldBean helloWorldBeanWithName(@PathVariable String name){
        return  new HelloWorldBean(name);
    }

    @GetMapping(path = "todo/{username}/{id}")
    public  Todo findById(@PathVariable String username,@PathVariable int id){
        return todoService.findById(id);
    }
    @DeleteMapping(path = "todo/{username}/{id}")
    public ResponseEntity<Void> deletById(@PathVariable String username, @PathVariable int id){
       todoService.deleteById(id);
       return  ResponseEntity.noContent().build();
    }
    @PutMapping(path = "todo/{username}/{id}")
    public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(todo);
        return  todo;
    }
    @PostMapping (path = "todo/{username}")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo){
        Todo createdTodo = todoService .addTodo(username,todo.getDescription(),todo.getLocalDate(),todo.isIsdone() );
        return  createdTodo;
    }
}

