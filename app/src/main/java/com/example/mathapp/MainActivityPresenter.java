package com.example.mathapp;


import android.util.Log;

import com.example.mathapp.Const.Api;
import com.example.mathapp.model.Question;
import com.example.mathapp.service.IQuestionService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private Helper helper = new Helper();

    public MainActivityPresenter(Helper helper) {
        this.helper = helper;
    }

    @Override
    public void setView(MainActivityContract.View view) {
        this.view = view;
    }

    public void created() {
        this.view.bindView();
        this.view.initOnClick();
        this.view.loadImages();
        getQuestionList();
        Log.d("eda","cerated çalıştı");
    }

    public void getQuestionList() {
         final MainActivityContract.View vieww=this.view;
        IQuestionService iMainService = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(IQuestionService.class);

        iMainService.getQuestions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Question>>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(List<Question> questionList) {
                                   vieww.showQuestions(questionList);
                                   Log.d("eda","onnext");
                               }

                               @Override
                               public void onError(Throwable e) {
                                   // mView.showError(e.toString());
                                   Log.d("eda",e.toString());
                               }

                               @Override
                               public void onComplete() {
                                   Log.d("eda","oncomplete");

                               }
                           }
                );
    }



    @Override
    public void onTryClick(String s1, String s2) {
        String sonuc=this.helper.islemYap(s1,s2);
        this.view.initView(sonuc);
    }
}
