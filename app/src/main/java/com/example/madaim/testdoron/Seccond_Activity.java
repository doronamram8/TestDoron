package com.example.madaim.testdoron;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Seccond_Activity extends Activity implements View.OnClickListener {
    EditText get;
    Button cap;
    Button smal;
    Button origin;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccond_);
        cap=(Button)findViewById(R.id.button2);
        smal=(Button)findViewById(R.id.button3);
        origin=(Button) findViewById(R.id.button4);
        back=(Button)findViewById(R.id.button5);
        get=(EditText)findViewById(R.id.ED2);
        get.setText(getIntent().getStringExtra("xxx"));
        cap.setOnClickListener((View.OnClickListener) this);
        smal.setOnClickListener((View.OnClickListener) this);
        origin.setOnClickListener((View.OnClickListener) this);
        back.setOnClickListener((View.OnClickListener) this);


    }
        public void onClick(View view){
            switch (view.getId()){
                case R.id.button2:
                    String text = get.getText().toString();
                   text.toUpperCase();
                     break;
                case R.id.button3:
                    String text2 = get.getText().toString();
                   text2.toLowerCase();
                    break;
                case R.id.button4:
                    get.setText("");
                    break;
                case R.id.button5:
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("xxx", get.getText().toString());
                    startActivity(intent);




            }
        }
}
