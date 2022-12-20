package com.example.kelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class contact extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        btn = findViewById(R.id.btnContact);

        final String num = "+62811808806";
        final String text = "Hello";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean installed = isAppInstalled("com.whatsapp");

                if (installed)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send/?phone=62811808806&text=Selamat+Datang+Di+Rumah+Sakit+Permata+Cibubur.+Percayakan+kesehatan+Anda+dan+keluarga+hanya+dengan+tim+medis+Kami.&type=phone_number&app_absent=0"+num+"&text="+ text));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(contact.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }

}