package com.example.caculateareaoftriangleperimeteroftriangle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private EditText side1;
    private EditText side2;
    private EditText side3;
    private TextView result;
     private Button  btncal ;

    private double rside1 ;
    private double rside2 ;
    private double rside3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        checkInstanceState(savedInstanceState);

        side1 = findViewById(R.id.side1);
        side2 = findViewById(R.id.side2);
        side3 = findViewById(R.id.side3);
        result = findViewById(R.id.result);
        btncal = findViewById(R.id.btncal);

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePerimeter();
            }
        });



    }

    public void calculatePerimeter() {
        try {

             rside1 = Double.parseDouble(side1.getText().toString());
             rside2 = Double.parseDouble(side2.getText().toString());
             rside3 = Double.parseDouble(side3.getText().toString());

            double perimeter = rside1 + rside2 + rside3;
            result.setText(String.valueOf(perimeter));
            result.setVisibility(View.VISIBLE);
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., non-numeric input)
            result.setText("Invalid input");
            result.setVisibility(View.VISIBLE);
        }
    }

    public void checkInstanceState(Bundle savedInstanceState){
        if (savedInstanceState!=null) {
            savedInstanceState.getDouble("side1");
            savedInstanceState.getDouble("side2");
            savedInstanceState.getDouble("side3");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("side1",rside1);
        outState.putDouble("side2",rside2);
        outState.putDouble("side3",rside3);



    }
}
