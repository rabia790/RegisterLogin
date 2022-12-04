package com.example.registrationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView main;
    String i = "";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.username);
        i = getIntent().getStringExtra("key");
        main.setText(GeneralApplication.getList().get(Integer.parseInt(i)).getUsername()
                + "\n" + GeneralApplication.getList().get(Integer.parseInt(i)).getEmail()
                + "\n" + GeneralApplication.getList().get(Integer.parseInt(i)).getPassword());
    }
}