package com.example.registrationlogin;

import android.app.Application;

import java.util.ArrayList;

public class GeneralApplication extends Application {
    static ArrayList<Student> commonList;

    @Override
    public void onCreate() {
        super.onCreate();
        commonList = new ArrayList<>();
    }

    static public ArrayList<Student> getList() {

        return commonList;
    }

    static public void setList(ArrayList<Student> list) {

        commonList = list;
    }
}
