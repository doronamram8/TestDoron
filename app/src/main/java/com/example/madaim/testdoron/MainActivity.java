package com.example.madaim.testdoron;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
        public Button push;
        public EditText ed;
        public TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         push=(Button) findViewById(R.id.button);
        ed=(EditText)findViewById(R.id.edT);
         TextWatcher tv1=new TextHandler();
           ed.addTextChangedListener(tv1);
         tv=(TextView)findViewById(R.id.textView2);
         push.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 Intent intent = new Intent(MainActivity.this,Seccond_Activity.class);
                intent.putExtra("content", ed.getText().toString());
                startActivityForResult(intent,1);
             }
        });


        ed.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (s.toString().equals("")) {
                    push.setEnabled(false);
                } else {
                    push.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        });

         }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK){
            String message=data.getStringExtra("content");
            ed.setText(message);
        }
    }


    private class TextHandler implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void afterTextChanged(Editable editable) {
            int cnt=ed.getText().length();
             push.setEnabled(cnt>0);
            if(cnt>150){
                Toast.makeText(MainActivity.this,"You are not allowd to type 150 chars",Toast.LENGTH_LONG ).show();
            }
            tv.setText(Integer.toString(cnt));
        }
    }
}


