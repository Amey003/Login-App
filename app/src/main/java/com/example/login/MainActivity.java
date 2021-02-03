package com.example.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edUsername;
    private EditText edPassword;
    private Button btnLogin;
    private Button btnUp;
    private final String CREDENTIAL_SHAERED = "our_shared_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUsername = findViewById(R.id.username);
        edPassword = findViewById(R.id.passwd);
        btnLogin = findViewById(R.id.btn_login);
        btnUp = findViewById(R.id.btn_up);

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , SignUp.class);
                startActivity(intent);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credentials =getSharedPreferences(CREDENTIAL_SHAERED, getBaseContext().MODE_PRIVATE);
                String strUsername = credentials.getString("Username",null);
                String strPassword = credentials.getString("Password",null);

                String username_from_ed = edUsername.getText().toString();
                String pass_from_ed = edPassword.getText().toString();

                if(strUsername != null && username_from_ed!=null && strUsername.equalsIgnoreCase(username_from_ed)){
                    if (strPassword != null && pass_from_ed!=null & strPassword.equalsIgnoreCase(pass_from_ed)){
                        Toast.makeText(MainActivity.this,"Login Complet",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"You are fail to login",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"You are fail to login",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
