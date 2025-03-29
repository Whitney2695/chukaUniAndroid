package com.example.chukauni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OurCourses extends AppCompatActivity {
    ListView lstView;
    String courses[] = {
            "Computer Science",
            "Information and Communication Technology (ICT)",
            "Information Science",
            "Community Development",
            "Software Engineering",
            "Cyber Security",
            "Artificial Intelligence",
            "Data Science",
            "Business Information Technology",
            "Networking and System Administration",
            "Database Management",
            "Game Development",
            "Web Development",
            "Mobile Application Development",
            "Cloud Computing",
            "Machine Learning",
            "Digital Marketing",
            "E-commerce and Online Business",
            "Graphics and Multimedia Design",
            "Human-Computer Interaction",
            "Bioinformatics",
            "Blockchain Technology",
            "Ethical Hacking and Penetration Testing",
            "Internet of Things (IoT)",
            "Embedded Systems",
            "Robotics and Automation"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_our_courses);

        lstView = (ListView) findViewById(R.id.lst);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
        lstView.setAdapter(adapter);


        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent s =new Intent(OurCourses.this, ApplyHere.class);
                    startActivity(s);

                } else if (position == 1) {

                } else {

                }


            }
        });
    }
};


