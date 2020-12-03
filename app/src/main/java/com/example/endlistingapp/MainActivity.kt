package com.example.endlistingapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getItemListing()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        viewModel.getListingSuccess().observe(this, Observer {
            tv_item_count.text = it.product_count.toString() + getString(R.string.item_count)
            rv_listing.apply {
                adapter = ListingAdapter(it.products)
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }

        })
        viewModel.getError().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

}