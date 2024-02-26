package com.my.securetext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Part_3 extends AppCompatActivity {
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        next= findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Next Button Clicked", Toast.LENGTH_LONG).show();
                Intent temp= new Intent(Part_3.this,MainActivity.class);
                startActivity(temp);

            }
        });
    }
}