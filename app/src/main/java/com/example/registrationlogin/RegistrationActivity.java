package com.example.registrationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {
    ArrayList<Student> studentArrayList = new ArrayList<>();
    EditText email, password, username;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = findViewById(R.id.tlEmailId);
        password = findViewById(R.id.et_password);
        username = findViewById(R.id.tlPhoneNumber);
        submit = findViewById(R.id.btnLogin);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }
    public void submit() {
        if (email.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (username.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your Username", Toast.LENGTH_SHORT).show();
            return;
        }

        if (GeneralApplication.getList().size() == 0) {
            studentArrayList.add(new Student(username.getText().toString(), password.getText().toString(), email.getText().toString()));
            GeneralApplication.setList(studentArrayList);
            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();
           // textToSpeech.speak(tlPhoneNumber.getText().toString() + "Register Successfully", TextToSpeech.QUEUE_FLUSH, null);
            finish();

        } else {
            for (int i = 0; i < GeneralApplication.getList().size(); i++) {
                if (username.getText().toString().equalsIgnoreCase(GeneralApplication.getList().get(i).getUsername())) {
                    Toast.makeText(this, "Username already taken", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    return;
                } else {
                    studentArrayList.add(new Student(username.getText().toString(), password.getText().toString(), email.getText().toString()));
                    GeneralApplication.setList(studentArrayList);
                    Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();
                    //textToSpeech.speak(tlPhoneNumber.getText().toString() + "Register Successfully", TextToSpeech.QUEUE_FLUSH, null);
                    finish();
                }
            }
        }
    }
}