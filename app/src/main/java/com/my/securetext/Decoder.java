package com.my.securetext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Decoder extends AppCompatActivity {
    EditText etdec;
    TextView dectv;
    ClipboardManager cplboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);

        etdec= findViewById(R.id.etdec);
        dectv= findViewById(R.id.dectv);
        cplboard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }
    public void dec(View view){
        String temp= etdec.getText().toString();
        String rv= Decode.dec(temp);
        dectv.setText(rv);
        Toast.makeText(this, "Decrypt", Toast.LENGTH_SHORT).show();
    }
    public void rec(View view){
        EditText etdec= findViewById(R.id.etdec);
        etdec.setText("");
        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show();
    }
    public void cp1(View view){
        String data= dectv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp= ClipData. newPlainText("text",data);
            cplboard.setPrimaryClip(temp);
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        }
    }

    public void m_app(View view){
        String data= dectv.getText().toString().trim();
        if(!data.isEmpty()){
            composeEmail(data);
            Toast.makeText(this, "More App", Toast.LENGTH_LONG).show();
        }
    }

    public void composeEmail(String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}