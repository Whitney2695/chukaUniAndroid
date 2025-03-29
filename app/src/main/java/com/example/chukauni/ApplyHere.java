package com.example.chukauni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.loopj.android.http.TextHttpResponseHandler;

import org.jetbrains.annotations.Async;

import cz.msebera.android.httpclient.Header;

public class ApplyHere extends AppCompatActivity {

    EditText a,b,c,d;
    Button e, f;
    String names,emails,phone,courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apply_here);

        a=(EditText) findViewById(R.id.names);
        b=(EditText) findViewById(R.id.email);
        c=(EditText) findViewById(R.id.phone);
        d=(EditText) findViewById(R.id.course);

        e=(Button) findViewById(R.id.reset);
        f=(Button) findViewById(R.id.submit);

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setText("");
                b.setText("");
                c.setText("");
                d.setText("");

            }
        });


        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                names=a.getText().toString();
                emails=b.getText().toString();
                phone=c.getText().toString();
                courses=d.getText().toString();

                if(names.isBlank()||emails.isEmpty()||phone.isEmpty()||courses.isEmpty()){

                    Toast.makeText(ApplyHere.this, "Fill in all the fileds", Toast.LENGTH_SHORT).show();
                }

                else{

                    AsyncHttpClient client =new AsyncHttpClient();
                    RequestParams params =new RequestParams();
                    params.add("names", names);
                    params.add("email", emails);
                    params.add("phone", phone);
                    params.add("course", courses);
                        client.post("https://hostclouds.co.ke/chuka/index.php", params, new TextHttpResponseHandler() {
                            @Override
                            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                                Toast.makeText(ApplyHere.this, "Failed to connect to the server", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                                Toast.makeText(ApplyHere.this, "Succesfully connected to the server", Toast.LENGTH_SHORT).show();
                            }
                        });
                }
            }
        });
    }
}


