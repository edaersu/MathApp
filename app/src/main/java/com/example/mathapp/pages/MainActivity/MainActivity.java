package com.example.mathapp.pages.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mathapp.R;
import com.example.mathapp.pages.MainActivity.model.Question;
import com.example.mathapp.pages.SplashActivity.SplashActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View {


    @BindView(R.id.tv1)
    EditText tv1;
    @BindView(R.id.tv2)
    EditText tv2;
    @BindView(R.id.btn_islem)
    Button btnIslem;
    @BindView(R.id.sonuc)
    TextView sonuc;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.ikincisayfa)
    Button ikincisayfa;

    private MainActivityPresenter presenter;
    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        helper = new Helper();
        this.presenter = new MainActivityPresenter(helper);
        presenter.setView(this);
        presenter.created();
    }

    @Override
    public void bindView() {
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        // msonuc=findViewById(R.id.sonuc);
        btnIslem = findViewById(R.id.btn_islem);
    }

    @Override
    public void initOnClick() {
        this.btnIslem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTryClick(tv1.getText().toString(), tv2.getText().toString());
            }
        });

        this.ikincisayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), SplashActivity.class);
                startActivity((i));
            }
        });
    }

    @Override
    public void initView(String s) {
        sonuc.setText(s);
    }

    @Override
    public void showQuestions(List<Question> questionList) {
        for (Question q:questionList) {
            System.out.println(q.getS1()+" "+q.getS2()+" "+q.getIslem());
        }
    }

    @Override
    public void loadImages() {
        Glide.with(getApplicationContext())
                .load("https://www.pngkey.com/png/full/34-349471_soru-iareti-pregnancy.png")
                .centerCrop()
                .into(image);
    }
}