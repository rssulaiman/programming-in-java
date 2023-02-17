package com.example.codeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {

    Button lancerpartiebtn, choisirlechapitrebtn;
    ImageView imageView7, imageView8;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        lancerpartiebtn = findViewById(R.id.lancerpartiebtn);
        lancerpartiebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, LancerPartieActivity.class));
            }
        });

        imageView7 = findViewById(R.id.imageView7);

        imageView8 = findViewById(R.id.imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, HomeActivity.class));
            }
        });

        choisirlechapitrebtn = findViewById(R.id.choisirlechapitrebtn);
        choisirlechapitrebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, ChoisirLeChapitreActivity.class));
            }
        });
    }
}