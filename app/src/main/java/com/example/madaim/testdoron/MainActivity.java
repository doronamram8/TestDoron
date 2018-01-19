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
        int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        push=(Button) findViewById(R.id.button);
        ed=(EditText)findViewById(R.id.edT);
        tv=(TextView)findViewById(R.id.textView2);
        push.setEnabled(false);
        push.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                 Intent intent = new Intent(getApplicationContext(),Seccond_Activity.class);
                intent.putExtra("xxx", ed.getText().toString());
                startActivity(intent);
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
        public void text(View v){
            ed=(EditText)findViewById(R.id.edT);
            String edf=ed.getText().toString();
            cnt=edf.length();
            tv.setText(cnt);
             if(ed.getText().length()>=150){
                Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_LONG).show();
            }

        }

}


