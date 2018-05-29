package com.example.quentinvarlet.foxrp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button btnLogin;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.login_button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( email.getText().toString().equals("") || password.getText().toString().equals("") ){
                    builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Erreur");
                    builder.setMessage("Entrer un email et un mot de passe");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else{
                    BackgroundTask backgroundTask = new BackgroundTask(LoginActivity.this);
                    backgroundTask.execute("login", email.getText().toString(), password.getText().toString());
                }
            }
        });
    }
}
