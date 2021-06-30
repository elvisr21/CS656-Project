package com.cs656.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

public class MessagePage extends AppCompatActivity {
    //components
    private Button Log_Out_Button;

    //Firebase variables
    FirebaseAuth fAuth;
    FirebaseFirestore db;

    //user data
    private String username;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_page);

        //Assign components to variables
        Log_Out_Button = findViewById(R.id.Log_Out);
        Log_Out_Button.setOnClickListener(new Loging_Out());

        //initialize firebase variable
        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        //get user data
        extras = getIntent().getExtras();

        if (extras !=null) {
            username = extras.getString("username");
        }
        else{
            db.collection("users").document(fAuth.getUid())
                    .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    username =  document.getString("username");

                                } else {
                                    Toast.makeText(MessagePage.this, "User doesn't exist in database", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MessagePage.this, "Error getting use data", Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(MessagePage.this, "Here", Toast.LENGTH_SHORT).show();

                        }
                    });
        }
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