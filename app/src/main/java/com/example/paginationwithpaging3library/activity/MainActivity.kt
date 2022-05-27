package com.example.paginationwithpaging3library.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.paginationwithpaging3library.adapter.Paging3Adapter
import com.example.paginationwithpaging3library.databinding.ActivityMainBinding
import com.example.paginationwithpaging3library.viewmodel.UserViewMode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewMode: UserViewMode
    private lateinit var paging3Adapter: Paging3Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        paging3Adapter = Paging3Adapter()
        binding.rv.adapter = paging3Adapter
        userViewMode = ViewModelProvider(this)[UserViewMode::class.java]
        initViews()
    }

    private fun initViews() {
        userViewMode.liveData.observe(this, Observer {
            GlobalScope.launch(Dispatchers.Main) {
                paging3Adapter.submitData(it)
            }
        })
    }
}