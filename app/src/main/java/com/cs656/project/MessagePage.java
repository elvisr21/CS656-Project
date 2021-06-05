package com.cs656.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MessagePage extends AppCompatActivity {
    //components
    private Button Log_Out_Button;

    //Firebase autho
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_page);

        //Assign components to variables
        Log_Out_Button = findViewById(R.id.Log_Out);
        Log_Out_Button.setOnClickListener(new Loging_Out());

        //initialize firebase variable
        fAuth = FirebaseAuth.getInstance();
    }
    class Loging_Out  implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            fAuth.signOut();
            startActivity(new Intent(MessagePage.this,MainActivity.class));
            finish();
        }
    }
}