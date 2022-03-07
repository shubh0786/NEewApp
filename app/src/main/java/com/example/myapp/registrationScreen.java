package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrationScreen extends AppCompatActivity {


    EditText username,password,RenterPassword;
    Button btSignUp, btSignIn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);

        username = (EditText) findViewById(R.id.editTextTextUserName);
        password = (EditText) findViewById(R.id.editTextPassword);
        RenterPassword = (EditText) findViewById(R.id.editTextRenterPassword);

        btSignUp = (Button) findViewById(R.id.btSignUp);
        btSignIn = (Button) findViewById(R.id.btSignIn);

        myDB = new DBHelper( this);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String Repass = RenterPassword.getText().toString();

                if (user.equals("")|| pass.equals("") || Repass.equals("")){

                    Toast.makeText(registrationScreen.this, " Fill All Values", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(Repass)) {

                        boolean usercheckResult = myDB.checkusername(user);
                        if (usercheckResult == false) {

                            Boolean regResult = myDB.insertData(user, pass);

                            if (regResult == true) {

                                Toast.makeText(registrationScreen.this, "Registration is Successfull", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                                startActivity(intent);


                            } else {

                                Toast.makeText(registrationScreen.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(registrationScreen.this, "USer Already Exists. \n Please Sign IN", Toast.LENGTH_SHORT).show();
                        }
                    } else {

                        Toast.makeText(registrationScreen.this, "Password not Matching.", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(intent);
            }
        });
    }
}