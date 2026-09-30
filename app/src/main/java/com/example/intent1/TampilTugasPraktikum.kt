package com.example.intent1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TampilTugasPraktikum : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val bundle = intent.extras
        val nim = bundle?.getString("nim") ?: ""
        val nama = bundle?.getString("nama") ?: ""
        val kelas = bundle?.getString("kelas") ?: ""
        val ipk = bundle?.getString("ipk") ?: ""
        val nilaimk1 = bundle?.getString("nilaimk1") ?: ""
        val nilaimk2 = bundle?.getString("nilaimk2") ?: ""
        val rata = bundle?.getString("rata") ?: ""

        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TampilTugasPraktikumScreen(
                        nim = nim,
                        nama = nama,
                        kelas = kelas,
                        ipk = ipk,
                        nilaimk1 = nilaimk1,
                        nilaimk2 = nilaimk2,
                        rata = rata,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TampilTugasPraktikumScreen(
    nim: String,
    nama: String,
    kelas: String,
    ipk: String,
    nilaimk1: String,
    nilaimk2: String,
    rata: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hasil Tugas Praktikum",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "NIM: $nim", fontSize = 16.sp)
                Text(text = "Nama: $nama", fontSize = 16.sp)
                Text(text = "Kelas: $kelas", fontSize = 16.sp)
                Text(text = "IPK: $ipk", fontSize = 16.sp)
                Text(text = "Nilai MK 1: $nilaimk1", fontSize = 16.sp)
                Text(text = "Nilai MK 2: $nilaimk2", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Rata-Rata: $rata",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
