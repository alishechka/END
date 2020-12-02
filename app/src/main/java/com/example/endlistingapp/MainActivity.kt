package com.example.endlistingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.endlistingapp.di.DaggerAppComponent
import com.example.endlistingapp.di.DaggerViewModelComponent
import com.example.endlistingapp.di.modules.NetworkModule
import com.example.endlistingapp.di.modules.ViewModelModule
import com.example.endlistingapp.network.EndClient
import com.example.endlistingapp.repository.Repository
import com.example.endlistingapp.repository.RepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDagger()
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

    private fun initDagger() {
        DaggerViewModelComponent.builder()
            .appComponent((applicationContext as MyApp).component())
            .viewModelModule(ViewModelModule(this))
            .build().inject(this)
    }
}