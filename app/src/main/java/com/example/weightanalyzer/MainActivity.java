package com.example.weightanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nme,wgt;
    Button anlz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            nme = findViewById(R.id.name);
            wgt = findViewById(R.id.weight);
            anlz = findViewById(R.id.btn);
            anlz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String uName=nme.getText().toString();
                    int uWgt= Integer.parseInt(wgt.getText().toString());
                    Intent i = new Intent(getApplication(), secondactivity.class);
                    i.putExtra("name",uName);
                    i.putExtra("weight",uWgt);
                    startActivity(i);

                }
            });

        };
    }
