package com.example.signupsqlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseAHelper databaseAHelper;

    private Button signUpButton, signInButton;
    private EditText nameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.signInId);
        signUpButton = findViewById(R.id.signUpId);

        nameEditText = findViewById(R.id.signInUserNameEditTextId);
        passwordEditText = findViewById(R.id.signInPasswordEditTextId);

        databaseAHelper = new DatabaseAHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseAHelper.getWritableDatabase();

        signUpButton.setOnClickListener(this);
        signInButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String userName = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (v.getId() == R.id.signInId){
            Boolean result = databaseAHelper.findPassword(userName, password);
            if (result == true)
            {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(MainActivity.this, "username and password does not matched", Toast.LENGTH_LONG).show();
            }
        }

        else if(v.getId() == R.id.signUpId){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }

    }
}