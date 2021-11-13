package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numberZero, numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven, numberEight, numberNine, point, sum, subtraction, multiplication, division, equal, buttonClear;

    private TextView expression, result;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCompanents();
        getSupportActionBar().hide();

        numberZero.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        point.setOnClickListener(this);
        sum.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);
        subtraction.setOnClickListener(this);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText("");
                result.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView exp = findViewById(R.id.expression);
                String value = exp.getText().toString();

                if(!value.isEmpty()) {
                    byte var0 = 0;
                    int var1 = value.length() - 1;
                    String express = value.substring(var0, var1);
                    exp.setText(express);
                }
                result.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression exp = new ExpressionBuilder(expression.getText().toString()).build();
                    double res = exp.evaluate();
                    long longResult = (long) res;

                    if (res == (double) longResult) {
                        result.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        result.setText((CharSequence) String.valueOf(res));
                    }
                } catch (Exception e) {

                }
            }
        });
    }

    private void initCompanents() {
        numberZero = findViewById(R.id.number_zero);
        numberOne = findViewById(R.id.number_one);
        numberTwo = findViewById(R.id.number_two);
        numberThree = findViewById(R.id.number_three);
        numberFour = findViewById(R.id.number_four);
        numberFive = findViewById(R.id.number_five);
        numberSix = findViewById(R.id.number_six);
        numberSeven = findViewById(R.id.number_seven);
        numberEight = findViewById(R.id.number_eight);
        numberNine = findViewById(R.id.number_nine);
        point = findViewById(R.id.point);
        sum = findViewById(R.id.sum);
        division = findViewById(R.id.division);
        equal = findViewById(R.id.equal);
        subtraction = findViewById(R.id.subtraction);
        multiplication = findViewById(R.id.multiplication);
        backspace = findViewById(R.id.backspace);
        result = findViewById(R.id.result);
        expression = findViewById(R.id.expression);
        buttonClear = findViewById(R.id.clear);
    }

    public void addExpression(String value, boolean clearValues) {
        if (result.getText().equals("")) {
            expression.setText(" ");
        }
        if (clearValues) {
            result.setText(" ");
            expression.append(value);
        } else {
            expression.append(result.getText());
            expression.append(value);
            result.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.number_zero:
                addExpression("0",true);
                break;
            case R.id.number_one:
                addExpression("1",true);
                break;
            case R.id.number_two:
                addExpression("2",true);
                break;
            case R.id.number_three:
                addExpression("3",true);
                break;
            case R.id.number_four:
                addExpression("4",true);
                break;
            case R.id.number_five:
                addExpression("5",true);
                break;
            case R.id.number_six:
                addExpression("6",true);
                break;
            case R.id.number_seven:
                addExpression("7",true);
                break;
            case R.id.number_eight:
                addExpression("8",true);
                break;
            case R.id.number_nine:
                addExpression("9",true);
                break;
            case R.id.point:
                addExpression(".",true);
                break;
            case R.id.sum:
                addExpression("+",false);
                break;
            case R.id.subtraction:
                addExpression("-",false);
                break;
            case R.id.multiplication:
                addExpression("*",false);
                break;
            case R.id.division:
                addExpression(".",false);
                break;
        }
    }
}