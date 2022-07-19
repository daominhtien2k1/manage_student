package com.example.managestudentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private RecyclerView recyclerViewStudents;
    private ArrayList<StudentModel> students;
    private StudentAdapter studentAdapter;
    private EditText searchStudent;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchStudent = findViewById(R.id.editSearchStudent);
        searchStudent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() <= (searchStudent.getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width())) {
                        Toast.makeText(MainActivity.this, searchStudent.getText().toString(), Toast.LENGTH_LONG).show();

                        return true;
                    }
                }
                return false;
            }
        });

        recyclerViewStudents = findViewById(R.id.recyclerview_students);
        students = new ArrayList<>();
        createStudentsList();
        studentAdapter = new StudentAdapter(this,students);
        recyclerViewStudents.setAdapter(studentAdapter);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));

        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"MSSV", "Họ tên"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

    }
    private void createStudentsList(){
        students.add(new StudentModel("20190070","Đào Minh Tiến", "minhtienk64hust@gmail.com", "22/9/2001"));
        students.add(new StudentModel("20190071","Đào Minh Tiến", "minhtienk64hust@gmail.com", "22/9/2001"));
        students.add(new StudentModel("20190072","Đào Minh Tiến", "minhtienk64hust@gmail.com", "22/9/2001"));
        students.add(new StudentModel("20190073","Đào Minh Tiến", "minhtienk64hust@gmail.com", "22/9/2001"));
        students.add(new StudentModel("20190074","Đào Minh Tiến", "minhtienk64hust@gmail.com", "22/9/2001"));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }
    @Override

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}