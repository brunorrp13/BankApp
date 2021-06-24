package com.example.bankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.bankapp.databinding.ActivityMainBinding
import com.example.bankapp.presentation.adapter.ExtratoAdapter
import com.example.bankapp.presentation.viewmodel.ViewModel
import com.example.bankapp.presentation.viewmodel.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    @Inject
    lateinit var extratoAdapter: ExtratoAdapter

    lateinit var viewModel: ViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,factory)
            .get(ViewModel::class.java)
    }
}