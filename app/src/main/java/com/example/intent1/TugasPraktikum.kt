package com.example.intent1

import android.content.Intent
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TugasPraktikum : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TugasPraktikumScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        onSubmit = { nim, nama, kelas, ipk, nilaimk1, nilaimk2 ->
                            val explicit = Intent(this, TampilTugasPraktikum::class.java).apply {
                                putExtra("nim", nim)
                                putExtra("nama", nama)
                                putExtra("kelas", kelas)
                                putExtra("ipk", ipk)
                                putExtra("nilaimk1", nilaimk1)
                                putExtra("nilaimk2", nilaimk2)
                                val n1 = nilaimk1.toDoubleOrNull() ?: 0.0
                                val n2 = nilaimk2.toDoubleOrNull() ?: 0.0
                                val rata = (n1 + n2) / 2
                                putExtra("rata", rata.toString())
                            }
                            startActivity(explicit)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TugasPraktikumScreen(
    modifier: Modifier = Modifier,
    onSubmit: (String, String, String, String, String, String) -> Unit
) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }
    var ipk by remember { mutableStateOf("") }
    var nilaimk1 by remember { mutableStateOf("") }
    var nilaimk2 by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(24.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Form Tugas Praktikum",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = kelas,
            onValueChange = { kelas = it },
            label = { Text("Kelas") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = ipk,
            onValueChange = { ipk = it },
            label = { Text("IPK") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = nilaimk1,
            onValueChange = { nilaimk1 = it },
            label = { Text("Nilai MK 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = nilaimk2,
            onValueChange = { nilaimk2 = it },
            label = { Text("Nilai MK 2") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onSubmit(nim, nama, kelas, ipk, nilaimk1, nilaimk2) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit Data")
        }
    }
}
