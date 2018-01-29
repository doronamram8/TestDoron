package com.example.madaim.testdoron;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Seccond_Activity extends Activity implements View.OnClickListener {
        String origi;

     @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccond_);
        Intent i=getIntent();
        String origi=i.getStringExtra("content");
        TextView tv=findViewById(R.id.ED2);
         tv.setText(origi);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
         findViewById(R.id.button4).setOnClickListener(this);
         findViewById(R.id.button5).setOnClickListener(this);



     }
        public void onClick(View view){
            TextView tv=findViewById(R.id.ED2);
             String message=tv.getText().toString();
            switch (view.getId()){
                case R.id.button2:
                    tv.setText(message.toUpperCase());
                      break;
                case R.id.button3:
                    tv.setText(message.toLowerCase());
                    break;
                case R.id.button4:
                           tv.setText(origi);

                     break;
                case R.id.button5:
                    Intent intent =new Intent();
                    intent.putExtra("content",message);
                    setResult(1,intent);
                    finish();



            }
        }
}
