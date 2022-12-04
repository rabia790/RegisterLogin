package com.example.registrationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginBtn();
            }
        });

    }
    public void loginBtn(){
        if (email.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your Password", Toast.LENGTH_SHORT).show();
            return;
        }
        for (int i = 0; i < GeneralApplication.commonList.size(); i++) {
            if (!email.getText().toString().equalsIgnoreCase(GeneralApplication.getList().get(i).getEmail()) || !password.getText().toString().equalsIgnoreCase(GeneralApplication.getList().get(i).getPassword())) {
                Toast.makeText(this, "email and password didn't match", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                //textToSpeech.speak(GeneralApplication.getList().get(i).getUsername() + "Login Successfully", TextToSpeech.QUEUE_FLUSH, null);
                startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("key", String.valueOf(i)));
            }
        }
    }
}