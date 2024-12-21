package com.example.question2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.activity_bottom_sheet);

        sharedPreferences = getSharedPreferences("notificationPreferences", MODE_PRIVATE);

        Button btnConfirm = bottomSheetDialog.findViewById(R.id.btnConfirm);
        Button btnCancel = bottomSheetDialog.findViewById(R.id.btnCancel);

        boolean sound = getIntent().getBooleanExtra("sound", false);
        boolean vibration = getIntent().getBooleanExtra("vibration", false);
        boolean led = getIntent().getBooleanExtra("led", false);
        boolean banners = getIntent().getBooleanExtra("banners", false);
        boolean content = getIntent().getBooleanExtra("content", false);
        boolean lock = getIntent().getBooleanExtra("lock", false);

        if (btnConfirm != null) {
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("sound", sound);
                    editor.putBoolean("vibration", vibration);
                    editor.putBoolean("led", led);
                    editor.putBoolean("banners", banners);
                    editor.putBoolean("content", content);
                    editor.putBoolean("lock", lock);
                    editor.apply();

                    finish();
                }
            });
        }

        if (btnCancel != null) {
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        bottomSheetDialog.show();
    }
}
