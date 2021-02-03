package com.example.login;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    private EditText edUsername1;
    private EditText edPassword1;
    private EditText edConfpass;
    private Button edUp;
    private final String CREDENTIAL_SHAERED = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edUsername1 = findViewById(R.id.username1);
        edPassword1 = findViewById(R.id.passwd1);
        edConfpass = findViewById(R.id.passwd2);
        edUp = findViewById(R.id.btn_up1);

        edUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPassword1 = edPassword1.getText().toString();
                String strConfpass = edConfpass.getText().toString();
                String strUsername = edUsername1.getText().toString();


                if(strPassword1 != null && strConfpass != null && strPassword1.equalsIgnoreCase(strConfpass)){
                    SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHAERED , getBaseContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("Password",strPassword1);
                    editor.putString("Username",strUsername);
                    editor.commit();


                    SignUp.this.finish();
                }
            }
        });
    }
}
