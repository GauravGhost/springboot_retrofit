package com.example.first;

import com.example.first.thirdParty.retrofit.Todo;
import com.example.first.thirdParty.retrofit.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable("id") String id) throws IOException {
        String url = "https://jsonplaceholder.typicode.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TodoService todoService = retrofit.create(TodoService.class);
        return todoService.getTodos(id).execute().body();
    }
}
