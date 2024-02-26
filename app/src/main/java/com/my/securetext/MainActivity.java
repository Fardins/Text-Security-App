package com.my.securetext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button enc, dec, abt;
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        enc= findViewById(R.id.encd);
        dec= findViewById(R.id.decd);
        enc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Encryption Button Clicked", Toast.LENGTH_LONG).show();
                Intent temp= new Intent(MainActivity.this,Encoder.class);
                startActivity(temp);

            }
        });
        dec.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Decryption Button Clicked", Toast.LENGTH_LONG).show();
                Intent temp= new Intent(MainActivity.this,Decoder.class);
                startActivity(temp);

            }
        });

        vf=findViewById(R.id.vf);
        int images[]= {R.drawable.pic3,R.drawable.pic4,R.drawable.pic5};

        for(int i=0; i< images.length; i++){
            flipper (images [i]);
        }
    }
    public void flipper (int images){
        ImageView test= new ImageView(this);
        test.setBackgroundResource(images);
        vf.addView(test);
        vf.setFlipInterval(3000);
        vf.setAutoStart(true);
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }
}