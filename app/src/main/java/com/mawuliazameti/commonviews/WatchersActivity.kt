package com.mawuliazameti.commonviews

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mawuliazameti.commonviews.databinding.ActivityWatchersBinding

class WatchersActivity : AppCompatActivity() {
    lateinit var binding: ActivityWatchersBinding
    lateinit var watcherAdapter: WatcherAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWatchersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        watcherAdapter = WatcherAdapter() { watcher ->
            Toast.makeText(this, "${watcher.name} clicked", Toast.LENGTH_SHORT).show()
        }

        binding.watchers.adapter = watcherAdapter

        watcherAdapter.submitList(watcherLists)

    }
}