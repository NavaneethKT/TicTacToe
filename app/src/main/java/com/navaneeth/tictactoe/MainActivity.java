package com.navaneeth.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button play_button;
    Button play_button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_button = findViewById(R.id.play_button);
        play_button2 = findViewById(R.id.play_button2);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                String msg = "true";
                intent.putExtra("key", msg);
                startActivity(intent);
            }
        });

        play_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                String msg = "false";
                intent.putExtra("key", msg);
                startActivity(intent);
            }
        });
    }
}