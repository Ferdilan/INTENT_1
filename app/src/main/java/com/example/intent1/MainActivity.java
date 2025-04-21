/************************************************************
 * Ditulis oleh : Ferdilan Ramadhani
 * Kode ini ditulis dengan kesungguhan, diketik dengan harapan.
 ************************************************************/

package com.example.intent1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//    Deklarasi Variabel
    Button button_ex;
    Button button_imp;
    Button button_intetExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        Pengenalan komponen
        button_ex = findViewById(R.id.button_explicit);
        button_imp = findViewById(R.id.button_implicit);
        button_intetExtra = findViewById(R.id.button_extra);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void HandleExplicit(View view) {
        Intent explicit = new Intent(this, ExplicitIntent.class);
        startActivity(explicit);
    }

    public void HandleImplictIntent(View view) {
        Intent implicit = new Intent( Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(implicit);
    }

    public void HandleintentExra(View view) {
        Intent explicit = new Intent(this, IntentwithExtra.class);
        startActivity(explicit);

    }

    public void TugasPraktikum(View view) {
        Intent explicit = new Intent(this, TugasPraktikum.class);
        startActivity(explicit);
    }
}