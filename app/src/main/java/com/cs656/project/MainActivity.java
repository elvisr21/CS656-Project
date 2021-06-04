package com.cs656.project;

import androidx.appcompat.app.AppCompatActivity;

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

    //validators
    private String Username = "Admin@admin.com";
    private String Password = "12345678";

    //flags
    boolean isValid = false;
    int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigns components to variables
        C_Email = findViewById(R.id.Register_Email);
        C_Password = findViewById(R.id.Login_Password);
        C_Login_button = findViewById(R.id.Login_Button);
        C_Attemps = findViewById(R.id.Login_Attemps);

        //set onclick on Login button
        C_Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_email = C_Email.getText().toString();
                String input_password = C_Password.getText().toString();

                if (input_email.isEmpty() || input_password.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter all the details correctly", Toast.LENGTH_SHORT).show();
                }
                else{
                    isValid = validate(input_email,input_password);
                    if(!isValid){
                        counter--;
                        Toast.makeText(MainActivity.this,"Incorrect credentials", Toast.LENGTH_SHORT).show();
                        if (counter == 0){
                            C_Login_button.setEnabled(false);
                        }

                    }
                    else{
                        Toast.makeText(MainActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
                        //add code to go to new activity
                    }
                }
            }
        });
    }
    private boolean validate(String name, String password){
        if (name.equals(this.Username) && password.equals(this.Password)){
            return true;
        }
        return false;
    }
}