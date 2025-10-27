package com.example.instaclone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instaclone.R

class UserSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_selection)
        // Por simplicidad este Activity es una plantilla.
        // Aquí podrías listar usuarios sandbox y al seleccionarlo guardar en SharedPreferences.
    }
}
