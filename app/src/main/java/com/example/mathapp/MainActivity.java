package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{


    private MainActivityPresenter presenter;

    TextView msonuc;
    EditText mtv1,mtv2;
    Button mbtn;
    Helper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper=new Helper();
        this.presenter=new MainActivityPresenter(helper);
        this.presenter.setView(this);
        this.presenter.created();
    }

    @Override
    public void bindView() {
        mtv1=findViewById(R.id.tv1);
        mtv2=findViewById(R.id.tv2);
        msonuc=findViewById(R.id.sonuc);
        mbtn=findViewById(R.id.btn_islem);
    }

    @Override
    public void initOnClick() {
        this.mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTryClick(mtv1.getText().toString(),mtv2.getText().toString());
            }
        });
    }

    @Override
    public void initView(String s) {
        msonuc.setText(s);
    }
}