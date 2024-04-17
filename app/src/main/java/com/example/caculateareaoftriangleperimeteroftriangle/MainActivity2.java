package com.example.caculateareaoftriangleperimeteroftriangle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button btnnext;
    private Button btncal;
    private double rehigh;
   private  double rebase ;
    private EditText high;
    private EditText base;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnnext = findViewById(R.id.btnnext);
        btncal = findViewById(R.id.btncal);
        high = findViewById(R.id.high);
        base = findViewById(R.id.base);
        result = findViewById(R.id.result);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(); // Call next() method to start MainActivity3
            }
        });

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double area = Area();
                result.setText(String.valueOf(area));
                result.setVisibility(View.VISIBLE);
            }
        });

        checkInstance(savedInstanceState);

    }

    private void next() {
        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(intent);
    }

    public double Area() {
        rehigh = Double.parseDouble(high.getText().toString());
        rebase = Double.parseDouble(base.getText().toString());
        double area = 0.5 * rehigh * rebase; // corrected the calculation
        return area;
    }

    private void  checkInstance(Bundle savedInstanceState){
        if (savedInstanceState!=null){
            rehigh =savedInstanceState.getDouble("high");
            rebase =savedInstanceState.getDouble("base");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("high",rehigh);
        outState.putDouble("base",rebase);
    }
}
