package com.example.first.thirdParty.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoService {
    @GET("/todos/{id}")
    Call<Todo> getTodos(@Path("id") String user);
}
