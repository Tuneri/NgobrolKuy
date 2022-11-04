package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private CardView btn_login;
    private TextView btn_register, btn_forgetpass;
    private Intent login, register, forgetpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.login_btn);
        btn_register = findViewById(R.id.register_btn);
        btn_forgetpass = findViewById(R.id.forgetpass_btn);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(login);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

        btn_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetpass = new Intent(LoginActivity.this, LupaPasswordActivity.class);
                startActivity(forgetpass);
            }
        });
    }
}