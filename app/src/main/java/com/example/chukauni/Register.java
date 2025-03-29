package com.example.chukauni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    Button map,call,web,courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        call=(Button)findViewById(R.id.btncall);
        web=(Button)findViewById(R.id.btnmap);
        map=(Button)findViewById(R.id.btnmap);
        courses=(Button)findViewById(R.id.btncourse);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call=new Intent(Intent.ACTION_CALL, Uri.parse("tell:+254 758432130"));
                startActivity(call);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chuka.ac.ke/"));
                startActivity(web);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = -1.286389; // Example: Nairobi, Kenya
                double longitude = 36.817223;
                Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude));
                map.setPackage("com.google.android.apps.maps");
                startActivity(map);

            }
        });

        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent courses=new Intent(Register.this,OurCourses.class);
                startActivity(courses);

            }
        });



//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}