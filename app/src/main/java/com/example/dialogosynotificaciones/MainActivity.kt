package com.example.dialogosynotificaciones

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnSnackbar = findViewById<Button>(R.id.btnSnackbar)
        val btnAlertDialog = findViewById<Button>(R.id.btnAlertDialog)
        val btnProgressBar = findViewById<Button>(R.id.btnProgressBar)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        btnToast.setOnClickListener {
            Toast.makeText(this, "Kiubo Carnal", Toast.LENGTH_SHORT).show()
        }

        btnSnackbar.setOnClickListener { view ->
            Snackbar.make(view, "Adios Archivo", Snackbar.LENGTH_LONG)
                .setAction("Deshacer") {
                    Toast.makeText(this, "uy no", Toast.LENGTH_SHORT).show()
                }.show()
        }

        btnAlertDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Seguro?")
            builder.setMessage("¿Estás segurisisisisisisimo??")

            builder.setPositiveButton("Aceptar") { dialog, _ ->
                Toast.makeText(this, "Animo!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            builder.setNegativeButton("Cancelar") { dialog, _ ->
                Toast.makeText(this, "nel we", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            val dialog = builder.create()
            dialog.show()
        }

        btnProgressBar.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            btnProgressBar.isEnabled = false

            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                btnProgressBar.isEnabled = true
                Toast.makeText(this, "full weeee", Toast.LENGTH_SHORT).show()
            }, 3000)
        }
    }
}