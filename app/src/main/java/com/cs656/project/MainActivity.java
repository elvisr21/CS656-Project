package com.cs656.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //component variables
    private EditText C_Email;
    private EditText C_Password;
    private Button C_Login_button;
    private TextView C_Attemps;
    private Button C_GoToRegister;

    //flags
    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigns components to variables
        C_Email = findViewById(R.id.Login_Email);
        C_Password = findViewById(R.id.Login_Password);
        C_Login_button = findViewById(R.id.Login_Button);
        C_Attemps = findViewById(R.id.Login_Attemps);
        C_GoToRegister = findViewById(R.id.Login_Go_To_Register);

        //set onclick event  on Login button
        C_Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_email = C_Email.getText().toString();
                String input_password = C_Password.getText().toString();

                if (input_email.isEmpty() || input_password.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter all the details correctly", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!validate(input_email,input_password)){
                        counter--;
                        Toast.makeText(MainActivity.this,"Incorrect credentials", Toast.LENGTH_SHORT).show();
                        C_Attemps.setText("No. of tries left: " + counter);
                        if (counter == 0){
                            C_Login_button.setEnabled(false);
                        }

                    }
                    else{
                        Toast.makeText(MainActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MessagePage.class);
                        startActivity(intent);
                    }
                }
            }
        });
        //set onclick event on go to register button
        C_GoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);

            }
        });
    }
    private boolean validate(String name, String password){
        //add code here, send request and get data back

        return true;
    }
}