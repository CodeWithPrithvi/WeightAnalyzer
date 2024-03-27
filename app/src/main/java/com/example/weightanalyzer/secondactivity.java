package com.example.weightanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class secondactivity extends AppCompatActivity {
    TextView disp;
    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        disp = findViewById(R.id.results);
        share = findViewById(R.id.shareBtn);
        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        String userWeight = i.getStringExtra("weight");
        String userHeight=i.getStringExtra("height");
        String userGen=i.getStringExtra("gender");
        String message= analyze(userName,userWeight,userHeight,userGen);
        disp.setText(message);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userWeight,message);
            }
        });
        }

    public String analyze(String name, String weight, String height, String gender) {
        int weightValue = Integer.parseInt(weight);
        int heightValue = Integer.parseInt(height);
        double bmi = calculateBMI(weightValue, heightValue);

        if (gender.equalsIgnoreCase("male")) {
            if (bmi < 18.5) {
                return name + " you are underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                return name + " you have normal weight";
            } else {
                return name + " you are overweight";
            }
        } else if (gender.equalsIgnoreCase("female")) {
            if (bmi < 18.5) {
                return name + " you are underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                return name + " you have normal weight";
            } else {
                return name + " you are overweight";
            }
        } else {
            return "Invalid gender";
        }
    }

    private double calculateBMI(int weight, int height) {

        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }
        public void shareData(String nme,String mssg){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,nme+"'s weight analysis results");
        i.putExtra(Intent.EXTRA_TEXT,mssg);
        startActivity(Intent.createChooser(i,"Choose Platform"));
        }
}

