package com.cs656.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    //component variables
    private EditText C_Email;
    private EditText C_Password;
    private EditText C_Username;
    private Button C_Register_button;
    private Button C_GoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //assigns components to variables
        C_Email = findViewById(R.id.Register_Email);
        C_Password = findViewById(R.id.Register_Password);
        C_Register_button = findViewById(R.id.Register_Button);
        C_Username = findViewById(R.id.Register_Username);
        C_GoToLogin = findViewById(R.id.Register_Go_To_Login);

        // setting up go to Login event handler
        C_GoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);

            }
        });
        //set onclick event  on Login button
        C_Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_email = C_Email.getText().toString();
                String input_password = C_Password.getText().toString();
                String input_username = C_Username.getText().toString();

                if (input_email.isEmpty() || input_password.isEmpty() ||input_username.isEmpty()){
                    Toast.makeText(Register.this,"Please enter all the details correctly", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!validate(input_email,input_password)){
                        Toast.makeText(Register.this,"User Already Exist", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Register.this,"Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this,MessagePage.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    private boolean validate(String name, String password){
        //add code here, send request and get data back

        return true;
    }
}