package com.example.intent1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TampilTugasPraktikum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tampil_tugas_praktikum);

        TextView nimTextView = (TextView) findViewById(R.id.tampil_nim);
        TextView namaTextView = (TextView) findViewById(R.id.tampil_nama);
        TextView kelasTextView = (TextView) findViewById(R.id.tampil_kelas);
        TextView ipkTextView = (TextView) findViewById(R.id.tampil_ipk);
        TextView nilaimk1TextView = (TextView) findViewById(R.id.tampil_nilaimk1);
        TextView nilaimk2TextView = (TextView) findViewById(R.id.tampil_nilaimk2);
        TextView rataTextView = (TextView) findViewById(R.id.tampil_rata);

        Bundle bundle = getIntent().getExtras();
        String nim = bundle.getString("nim");
        String nama = bundle.getString("nama");
        String kelas = bundle.getString("kelas");
        String ipk = bundle.getString("ipk");
        String nilaimk1 = bundle.getString("nilaimk1");
        String nilaimk2 = bundle.getString("nilaimk2");
        String rata = bundle.getString("rata");

        nimTextView.setText("Nim: " + nim);
        namaTextView.setText("Nama: " + nama);
        kelasTextView.setText("Kelas: " + kelas);
        ipkTextView.setText("IPK: " + ipk);
        nilaimk1TextView.setText("Nilai MK 1: " + nilaimk1);
        nilaimk2TextView.setText("Nilai MK 2: " + nilaimk2);
        rataTextView.setText("Rata-Rata: " + rata);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}