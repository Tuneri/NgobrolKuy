package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UbahFotoActivity extends AppCompatActivity {

    private ImageView btn_back;
    private TextView ubahFotonya;
    private Intent back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_foto);

        btn_back = findViewById(R.id.back_btn);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back = new Intent(UbahFotoActivity.this, SettingActivity.class);
                startActivity(back);
            }
        });

        ubahFotonya = findViewById(R.id.konfirubahfoto);
        ubahFotonya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UbahFotoActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

    }
}