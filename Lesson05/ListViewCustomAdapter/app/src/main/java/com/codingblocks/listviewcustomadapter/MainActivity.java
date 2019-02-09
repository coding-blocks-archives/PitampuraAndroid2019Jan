package com.codingblocks.listviewcustomadapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students.add(new Student("Harshit", "Dwivedi", "Android"));
        students.add(new Student("Abhay", "Vashishth", "Android"));
        students.add(new Student("Abhinav", "Bhaduria", "Web"));
        students.add(new Student("Abhineet", "Singh", "Web"));
        students.add(new Student("Akshay", "Bharadwaj", "Web"));
        students.add(new Student("Ankit", "Bajaj", "Android"));
        students.add(new Student("Anuj", "Gupta", "Android"));
        students.add(new Student("Arnav ", "Chaudhary", "Android"));
        students.add(new Student("Dheeraj", "Yadav", "Web"));
        students.add(new Student("Keshav", "Mathur", "Android"));
        students.add(new Student("Raghav", "Goyal", "Android"));
        students.add(new Student("Rakshit", "Yadav", "Web"));
        students.add(new Student("Rohit", "Kumar", "Android"));
        students.add(new Student("Sahil", "Kakkar", "Web"));

        ListView listView = findViewById(R.id.listView);

        StudentAdapter studentAdapter = new StudentAdapter(students, this);

        listView.setAdapter(studentAdapter);
    }

//    public View findViewById(@IdRes int id) {
//
//        return inflatedView.findViewById(id);
//
//    }

}
