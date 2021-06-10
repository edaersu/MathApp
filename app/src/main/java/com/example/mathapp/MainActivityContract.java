package com.example.mathapp;

import com.example.mathapp.model.Question;

import java.util.List;

public interface MainActivityContract {

    interface View{


        public void bindView();

        public void initOnClick();

        void initView(String s);

        void showQuestions(List<Question> questionList);

        void loadImage();
    }

    interface Presenter{

        public void setView(View view);

        public void created();

        public void onTryClick(String s1,String s2);
    }
}
