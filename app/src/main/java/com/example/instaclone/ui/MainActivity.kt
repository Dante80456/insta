package com.example.instaclone.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaclone.R
import com.example.instaclone.RetrofitClient
import com.example.instaclone.models.InstagramPhoto
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PhotoAdapter
    private var currentUserId: String = "self"
    // Replace TU_ACCESS_TOKEN with your sandbox token
    private val accessToken = "TU_ACCESS_TOKEN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PhotoAdapter()
        recyclerView.adapter = adapter

        loadTimeline()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_set_user -> {
                startActivity(Intent(this, UserSelectionActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadTimeline() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.api.getRecentMedia(currentUserId, accessToken)
                val photos: List<InstagramPhoto> = response.data
                adapter.submitList(photos)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@MainActivity, "Error cargando timeline: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
