package com.example.deltahackathonfinal;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GameScreen extends AppCompatActivity {
    GridView gridView;
    ArrayList<Cells> cellsArrayList;
    private AdapterGrid gridAdapter;
    int color = 0;
    TextView Black,Cyan,Green,Red,Yellow,Magenta,Blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_screen);

        gridView = findViewById(R.id.gridview);

        cellsArrayList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            cellsArrayList.add(new Cells(0));
        }

        gridAdapter = new AdapterGrid(cellsArrayList, this);
        gridView.setAdapter(gridAdapter);

        Black = findViewById(R.id.black);
        Cyan = findViewById(R.id.cyan);
        Green = findViewById(R.id.green);
        Red = findViewById(R.id.red);
        Yellow = findViewById(R.id.yellow);
        Magenta = findViewById(R.id.magenta);
        Blue = findViewById(R.id.blue);

        Black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.parseColor(Black.getText().toString());
            }
        });
        Cyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.parseColor(Cyan.getText().toString());
            }
        });
        Green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.parseColor(Green.getText().toString());
            }
        });
        Red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.parseColor(Red.getText().toString());
            }
        });
        Yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.parseColor(Yellow.getText().toString());
            }
        });
        Magenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.parseColor(Magenta.getText().toString());
            }
        });
        Blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.parseColor(Blue.getText().toString());
            }
        });


        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Cells clickedCell = (Cells) parent.getItemAtPosition(position);
            gridAdapter.updateColor(position, color);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public int setColor(TextView view){
        String string = view.getText().toString();
        return(Color.parseColor(string));
    }
}