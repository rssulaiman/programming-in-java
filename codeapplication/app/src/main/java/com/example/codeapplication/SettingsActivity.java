package com.example.codeapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class SettingsActivity extends AppCompatActivity {

    ImageView imageView13, imageView14;
    Button logoutbtn, languagebutton;
    boolean lang_selected = true;
    Context context;
    Resources resources;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        imageView13 = findViewById(R.id.imageView13);
        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, HomeActivity.class));
            }
        });

        imageView14 = findViewById(R.id.imageView14);

        logoutbtn = findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        languagebutton = findViewById(R.id.languageButton);
        languagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] languages = {"English", "Français"};
                int checkedItem;
                if (lang_selected) {
                    checkedItem = 0;
                } else {
                    checkedItem = 1;
                }
                final AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("Select a language").setSingleChoiceItems(languages, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        languagebutton.setText(languages[which]);
                        if (languages[which].equals("English")) {
                            context = LocaleHelper.setLocale(SettingsActivity.this, "en");
                            resources = context.getResources();
                            logoutbtn.setText(resources.getString(R.string.loginemail));
                          //  loginpassword.setText(resources.getString(R.string.loginpassword));
                          //  loginbutton.setText(resources.getString(R.string.loginbutton));
                          //  dontHaveAccount.setText(resources.getString(R.string.dontHaveAccount));
                        }
                        if (languages[which].equals("Français")) {
                            context = LocaleHelper.setLocale(SettingsActivity.this, "fr");
                            resources = context.getResources();
                         //   loginemail.setText(resources.getString(R.string.loginemail));
                         //   loginpassword.setText(resources.getString(R.string.loginpassword));
                        //    loginbutton.setText(resources.getString(R.string.loginbutton));
                        //    dontHaveAccount.setText(resources.getString(R.string.dontHaveAccount));
                        }
                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }
    }
