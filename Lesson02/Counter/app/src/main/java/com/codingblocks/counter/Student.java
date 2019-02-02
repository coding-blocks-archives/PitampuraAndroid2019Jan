package com.codingblocks.counter;

import android.util.Log;

public class Student {

    public final String TAG = getClass().getSimpleName();

    private String name, address;

    private Student(String name, String address) {
        this.name = name;
        this.address = address;
        Log.e(TAG, "getInstance: ");
    }

    private static Student s;

    //This is your Singleton pattern
    public static Student getInstance(String name, String address) {

        if (s == null) {
            s = new Student(name, address);
        } else {
            s.name = name;
            s.address = address;
        }

        return s;

    }
}
