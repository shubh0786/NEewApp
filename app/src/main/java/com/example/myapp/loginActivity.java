package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLoginAct;

    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText) findViewById(R.id.userNameLogin);
        password = (EditText) findViewById(R.id.passwordLogin);
        btnLoginAct = (Button) findViewById(R.id.btnLoginAct);

        myDB = new DBHelper(this);

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override

            //Used On Focus Change Event Handler
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus && username.getText().toString() !=null){

                    Toast.makeText(getApplicationContext(), username.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnLoginAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
              
                if(user.equals("")|| pass.equals("") ){

                    Toast.makeText(loginActivity.this, "Please Enter the Credential", Toast.LENGTH_SHORT).show();
                }

                else    {

                 Boolean result =   myDB.checkusernamePassword(user,pass);

                    if (result == true){
                        Intent intent = new Intent(getApplicationContext(),MainHome.class);
                        intent.putExtra("KEY_SENDER", username.getText().toString());
                        startActivity(intent);

                        Toast.makeText(loginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(loginActivity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}