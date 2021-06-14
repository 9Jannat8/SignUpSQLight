package com.example.signupsqlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText, emailEditText, userNameEditText, passwordEditText;
    private Button signUpButton;
    UserDetails userDetails;
    DatabaseAHelper databaseAHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passWordEditTextId);
        databaseAHelper = new DatabaseAHelper(this);

        signUpButton = findViewById(R.id.signUpbuttonId);

        signUpButton.setOnClickListener(this);

        userDetails = new UserDetails();
    }

    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowId = databaseAHelper.insertData(userDetails);

        if (rowId > 0)
        {
            Toast.makeText(getApplicationContext(), "Row "+rowId+" is successfully inserted", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Row insertion is failed", Toast.LENGTH_LONG).show();
        }

    }
}