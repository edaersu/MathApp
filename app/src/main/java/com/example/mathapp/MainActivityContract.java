package com.example.mathapp;

public interface MainActivityContract {

    interface View{


        public void bindView();

        public void initOnClick();

        void initView(String s);
    }

    interface Presenter{

        public void setView(View view);

        public void created();

        public void onTryClick(String s1,String s2);
    }
}
