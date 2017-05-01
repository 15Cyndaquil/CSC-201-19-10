package com.example.cynda.csc_201_19_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity <E extends Comparable<E>> extends AppCompatActivity {

    TextView currentMax, currentList;
    EditText inputET;
    Button getCurrentMax, addInput;

    ArrayList<E> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = (EditText) findViewById(R.id.inputET);

        getCurrentMax = (Button) findViewById(R.id.getCurrentMax);
        addInput = (Button) findViewById(R.id.addInput);

        currentList = (TextView) findViewById(R.id.currentList);
        currentMax = (TextView) findViewById(R.id.currentMax);

        addInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder input = new StringBuilder();
                try {
                    list.add((E) Double.valueOf(inputET.getText().toString()));
                    currentList.setText("");
                    for(int i=0; i<list.size(); i++){
                        input.append(list.get(i).toString()+", ");
                    }
                    input.replace(input.length()-2, input.length(), "");
                    currentList.setText(input.toString());
                    inputET.setText("");
                }catch (NumberFormatException exc){
                }
            }
        });

        getCurrentMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentMax.setText(currentMax(list).toString());
            }
        });
    }

    public static <E extends Comparable<E>> E currentMax(ArrayList<E> list){
        E currentMax = list.get(0);
        for (E elements : list) {
            if (elements.compareTo(currentMax) > 0) {
                currentMax = elements;
            }
        }

        return currentMax;
    }
}
