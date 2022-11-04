package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ImageView btn_settings;
    private Intent data, settings;
    private String username, email, password;
    private Uri uri_avatar;
    private FloatingActionButton keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView setting = findViewById(R.id.settings_btn);
        LinearLayout chat = findViewById(R.id.chatBtn);

        setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        chat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatPersonalActivity.class);
                startActivity(intent);
            }
        });

        keluar = findViewById(R.id.keluarkelogin);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_settings = findViewById(R.id.settings_btn);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = getIntent();

                settings = new Intent(MainActivity.this, SettingActivity.class);

                username = data.getStringExtra("username");
                settings.putExtra("username", username);

                password = data.getStringExtra("password");
                settings.putExtra("password", password);

                email = data.getStringExtra("email");
                settings.putExtra("email", email);

                if(data.hasExtra("uri_avatar")) {
                    uri_avatar = data.getParcelableExtra("uri_avatar");
                    settings.putExtra("uri_avatar", uri_avatar);
                }

                startActivity(settings);
            }
        });

    }
}