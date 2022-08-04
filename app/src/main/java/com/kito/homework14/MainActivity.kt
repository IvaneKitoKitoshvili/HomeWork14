package com.kito.homework14

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kito.homework14.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: BuildingAdapter by lazy { BuildingAdapter() }

    private val viewModel: BuildingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvBuilding.adapter = adapter
        binding.rvBuilding.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            viewModel.viewState.collect {
                if (it.isSuccessful == true) {
                    viewModel.viewState.value.list?.let {
                        Log.d("bla bla", it?.content.toString())
                        adapter.submitList(it.content)
                    }
                } else {
                    viewModel.viewState.value.errorMsg?.let { msg ->
                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
