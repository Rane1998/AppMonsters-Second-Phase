package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    TextView UserName, Password, ClickHere;
    EditText UsernameAnswer, PasswordAnswer;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        UserName = findViewById(R.id.UserName);
        Password = findViewById(R.id.Password);
        //ClickHere = findViewById(R.id.ClickHere);
        UsernameAnswer = findViewById(R.id.UsernameAnswer);
        PasswordAnswer = findViewById(R.id.PasswordAnswer);
        btnLogin = findViewById(R.id.btnLogin);

        Button button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                if (Password.getText().length() == 0) {
                    Toast.makeText(LoginPage.this, "Please enter valid details!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        /*//link to Registration Page
        ClickHere = (TextView) findViewById(R.id.ClickHere);
        ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.this.ClickHere();
            }
        });*/

    }
}