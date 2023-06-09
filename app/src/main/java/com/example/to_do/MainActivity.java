package com.example.to_do;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemAdapter;
    ListView listView;
    Button button;
    EditText todo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        button=findViewById(R.id.enter);
        todo=findViewById(R.id.et_todo);

        items=new ArrayList<>();
        itemAdapter=new ArrayAdapter(this,R.layout.item_file,items);
        listView.setAdapter(itemAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                additem(view);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context=getApplicationContext();
                Toast.makeText(context,"Item Removed..",Toast.LENGTH_LONG).show();

                items.remove(i);
                itemAdapter.notifyDataSetChanged();
            }
        });

    }

    private void additem(View view) {
        items.add(todo.getText().toString());
        itemAdapter.notifyDataSetChanged();
        todo.setText("");

    }
}