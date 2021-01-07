package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {


    EditText etItemText;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItemText = findViewById(R.id.etItemText);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        etItemText.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // The button is clicked when the user is done editing
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent which contains the results of the user modification
                Intent intent = new Intent();
                // Pass the data results
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItemText.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // Set the result of the intent
                setResult(RESULT_OK, intent);
                // Finish the activity and close the current screen
                finish();
            }
        });
    }
}