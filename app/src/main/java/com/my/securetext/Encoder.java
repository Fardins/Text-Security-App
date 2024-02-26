package com.my.securetext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Encoder extends AppCompatActivity {

    EditText etenc;
    TextView enctv;
    ClipboardManager cpb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);

        etenc= findViewById(R.id.etenc);
        enctv= findViewById(R.id.enctv);
        cpb= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }
    public void enc(View view){
        String temp= etenc.getText().toString();
        String rv= Encode.enc(temp);
        enctv.setText(rv);
        Toast.makeText(this, "Encrypt", Toast.LENGTH_LONG).show();
    }
    public void rec(View view){
        EditText reset= findViewById(R.id.etenc);
        reset.setText("");
        Toast.makeText(this, "Reset", Toast.LENGTH_LONG).show();
    }
    public void cp2(View view){
        String data= enctv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp= ClipData. newPlainText("text",data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this, "Copied", Toast.LENGTH_LONG).show();
        }
    }
    public void m_app(View view){
        String data= enctv.getText().toString().trim();
        if(!data.isEmpty()){
            composeEmail(data);
            Toast.makeText(this, "More App", Toast.LENGTH_LONG).show();
        }
    }
    public void composeEmail( String subject) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}