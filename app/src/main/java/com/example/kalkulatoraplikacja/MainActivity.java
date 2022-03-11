package com.example.kalkulatoraplikacja;

import androidx.appcompat.app.AppCompatActivity;

import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String number1 = "", number2= "", operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evaluate(){
        Double num1 = Double.parseDouble(number1);
        Double num2 = Double.parseDouble(number2);
        Double result = 0.0;

        switch(operation){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        if(result % 1 == 0){
            number1 = ((Integer)result.intValue()).toString();
        }else{
            number1 = result.toString();
        }

        number2 = "";
    }

    public void addNumber(View view){
        Button button = (Button)view;
        String temp = button.getText().toString();
        //TextView tv = findViewById(R.id.editTextNumber);
        EditText et = findViewById(R.id.editTextNumber);
        //tv.setText(button.getText());

        if(operation.isEmpty()){
            number1 = number1.concat(temp);
        }else{
            number2 = number2.concat(temp);
        }

        et.setText(number1 + operation + number2);
    }

    public void addOperation(View view){
        Button button = (Button)view;
        String temp = button.getText().toString();
        EditText et = findViewById(R.id.editTextNumber);

        if(operation.isEmpty()){
            operation = temp;
        }else{
            if(!number1.isEmpty() && !number2.isEmpty()){
                evaluate();
                operation = temp;
            }
        }

        et.setText(number1 + operation + number2);
    }

    public void addEqualsSign(View view){
        EditText et = findViewById(R.id.editTextNumber);
        if(!number1.isEmpty() && !number2.isEmpty() && !operation.isEmpty()){
            evaluate();
            operation = "";
            et.setText(number1 + operation + number2);
        }
    }

    public void clean(View view){
        EditText et = findViewById(R.id.editTextNumber);

        number1 = "";
        number2 = "";
        operation = "";

        et.setText(number1 + operation + number2);
    }

}