package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivity extends AppCompatActivity {

    private TextView tv_username, tv_email, tv_password, ubahfoto, ubahpass;
    private String username, email, password;
    private Uri uri_avatar;
    private CircleImageView profile;
    private ImageView btn_back;
    private Intent data, back;

    private static final String TAG = ProfilePicActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        tv_username = findViewById(R.id.username_tv);
        tv_email = findViewById(R.id.email_tv);
        tv_password = findViewById(R.id.password_tv);

        profile = findViewById(R.id.profilepic);

        data = getIntent();
        username = data.getStringExtra("username");
        email = data.getStringExtra("email");
        password = data.getStringExtra("password");

        tv_username.setText(username);
        tv_email.setText(email);
        tv_password.setText(password);

        if(data.hasExtra("uri_avatar")) {
            uri_avatar = data.getParcelableExtra("uri_avatar");
            try {
                Bitmap avatarBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri_avatar);
                profile.setImageBitmap(avatarBitmap);
            } catch(IOException e) {
                Toast.makeText(SettingActivity.this,"Tidak bisa memuat gambar", Toast.LENGTH_SHORT).show();
                Log.e(TAG, e.getMessage());
            }
        }

        btn_back = findViewById(R.id.back_btn);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(back);
            }
        });

        ubahfoto = findViewById(R.id.ubahfotoBtn);
        ubahfoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, UbahFotoActivity.class);
                startActivity(intent);
            }
        });

        ubahpass = findViewById(R.id.ubahpassBtn);
        ubahpass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, UbahPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}