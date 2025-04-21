package com.example.intent1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TugasPraktikum extends AppCompatActivity {

    EditText nim, nama, kelas, ipk, nilaimk1, nilaimk2;
    Button buttonSubmitTugasPraktikum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tugas_praktikum);

        buttonSubmitTugasPraktikum = findViewById(R.id.submit_tugas_praktikum);
        nim = findViewById(R.id.input_nim);
        nama = findViewById(R.id.input_nama);
        kelas = findViewById(R.id.input_kelas);
        ipk = findViewById(R.id.input_ipk);
        nilaimk1 = findViewById(R.id.input_nilaimk1);
        nilaimk2 = findViewById(R.id.input_nilaimk2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void TampilTugasPraktikum(View view) {
        Intent explicit = new Intent(this, TampilTugasPraktikum.class);
        explicit.putExtra("nim", nim.getText().toString());
        explicit.putExtra("nama", nama.getText().toString());
        explicit.putExtra("kelas", kelas.getText().toString());
        explicit.putExtra("ipk", ipk.getText().toString());
        explicit.putExtra("nilaimk1", nilaimk1.getText().toString());
        explicit.putExtra("nilaimk2", nilaimk2.getText().toString());
        double nilai1 = Double.parseDouble(nilaimk1.getText().toString());
        double nilai2 = Double.parseDouble(nilaimk2.getText().toString());
        double rata = (nilai1 + nilai2) / 2;
        explicit.putExtra("rata", String.valueOf(rata));
        System.out.println(rata);

        startActivity(explicit);

    }
}