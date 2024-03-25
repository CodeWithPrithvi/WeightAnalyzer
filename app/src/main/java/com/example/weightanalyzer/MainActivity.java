package com.example.weightanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nme,wgt;
    Button anlz;
    Spinner activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

            nme = findViewById(R.id.name);
            wgt = findViewById(R.id.weight);
            anlz = findViewById(R.id.btn);
            activity = findViewById(R.id.activitySelecter);
            String[] activities={"No Form of Activity","Exercise 1-3 Times a Week","Exercise 4-6 Times a week","High Intensive Physical Work"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,activities);
            activity.setAdapter(adapter);
            anlz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String uName=nme.getText().toString();
                    String uWgt= wgt.getText().toString();
                    Intent i = new Intent(getApplication(), secondactivity.class);
                    i.putExtra("name",uName);
                    i.putExtra("weight",uWgt);
                    startActivity(i);

                }
            });

        };
    }
