package com.example.mathapp.service;

import io.reactivex.Observable;
import com.example.mathapp.model.Question;
import java.util.List;
import retrofit2.http.GET;

public interface IQuestionService {

    @GET("math.json")
    Observable<List<Question>> getQuestions();
}
