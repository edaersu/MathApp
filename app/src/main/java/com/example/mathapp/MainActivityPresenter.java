package com.example.mathapp;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private Helper helper=new Helper();

    public MainActivityPresenter(Helper helper) {
        this.helper = helper;
    }

    @Override
    public void setView(MainActivityContract.View view) {
        this.view=view;
    }

    public void created() {
        this.view.bindView();
        this.view.initOnClick();
    }

    @Override
    public void onTryClick(String s1, String s2) {
        String sonuc=this.helper.islemYap(s1,s2);
        this.view.initView(sonuc);
    }
}
