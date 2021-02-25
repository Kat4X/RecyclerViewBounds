package com.kat4x.boundsrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kat4x.boundsrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val itemAdapter by lazy { PageBackgroundAdapter().also { it.differ.submitList(generateListInt()) } }

    private fun generateListInt(): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 0 .. 20) {
            list.add(i)
        }
        return list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvBounds.run {
                layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                adapter = itemAdapter
                edgeEffectFactory = BounceEdgeEffectFactory()
            }
        }
    }
}