package com.example.question2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch swSound, swVibrate, swLed, swBanner, swContent, swLock;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        swSound = findViewById(R.id.swSound);
        swVibrate = findViewById(R.id.swVibrate);
        swLed = findViewById(R.id.swLed);
        swBanner = findViewById(R.id.swBanner);
        swContent = findViewById(R.id.swContent);
        swLock = findViewById(R.id.swLock);
        Button btnSave = findViewById(R.id.btnSave);

        sharedPreferences = getSharedPreferences("notificationPreferences", MODE_PRIVATE);
        swSound.setChecked(sharedPreferences.getBoolean("sound", false));
        swVibrate.setChecked(sharedPreferences.getBoolean("vibration", false));
        swLed.setChecked(sharedPreferences.getBoolean("led", false));
        swBanner.setChecked(sharedPreferences.getBoolean("banners", false));
        swContent.setChecked(sharedPreferences.getBoolean("content", false));
        swLock.setChecked(sharedPreferences.getBoolean("lock", false));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BottomSheetActivity.class);
                intent.putExtra("sound", swSound.isChecked());
                intent.putExtra("vibration", swVibrate.isChecked());
                intent.putExtra("led", swLed.isChecked());
                intent.putExtra("banners", swBanner.isChecked());
                intent.putExtra("content", swContent.isChecked());
                intent.putExtra("lock", swLock.isChecked());
                startActivity(intent);
            }
        });
    }
}
