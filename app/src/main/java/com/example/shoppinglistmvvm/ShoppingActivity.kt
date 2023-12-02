package com.example.shoppinglistmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.shoppinglistmvvm.data.db.ShoppingDatabase
import com.example.shoppinglistmvvm.data.repositories.ShoppingRepository
import com.example.shoppinglistmvvm.databinding.ActivityShoppingBinding
import com.example.shoppinglistmvvm.other.ShoppingItemAdapter
import com.example.shoppinglistmvvm.ui.ShoppingViewModel
import com.example.shoppinglistmvvm.ui.ShoppingViewModelFactory

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater).also { setContentView(it.root) }
        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
    }
}