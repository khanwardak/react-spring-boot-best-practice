package khan.cpm.fullstackcrudapp.service;

import khan.cpm.fullstackcrudapp.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private  static List<Todo> todos = new ArrayList<>();
    private  static int coutId =0;
    static {
        todos.add(new Todo(++coutId,"khan","learn ws ddd",true,LocalDate.now().plusYears(2)));
        todos.add(new Todo(++coutId,"khan","learn ws",false,LocalDate.now().plusYears(2)));
        todos.add(new Todo(++coutId,"khan","learn spring-boot",false,LocalDate.now().plusYears(1)));
        todos.add(new Todo(++coutId,"khan","learn react",false,LocalDate.now().plusYears(0)));
        todos.add(new Todo(++coutId,"imrankhan","learn ws",false,LocalDate.now().plusYears(5)));
    }
    public  List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public  void  deleteById(int id){
        Predicate<? super  Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
    @PostMapping(path = "todos")
    public Todo save(String username, String description, boolean isdone, LocalDate localDate){
        Todo todo = new Todo(++coutId,username,description,isdone,localDate);
        todos.add(todo);
        return  todo;
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public  void  updateTodo(Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean isDone ) {
        Todo todo = new Todo(++coutId,username,description, isDone, targetDate);
        todos.add(todo);
        return todo;
    }
}
