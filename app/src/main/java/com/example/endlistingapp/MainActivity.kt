package com.example.endlistingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
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

        val context: Context = MyApp.applicationContext()
        Timber.d(context.toString())

        initDagger()
        viewModel.getItemListing()
        viewModel.getListingSuccess().observe(this, Observer {
            test_text.text=it.title
        })
    }

    private fun initDagger() {
        DaggerViewModelComponent.builder()
            .appComponent((applicationContext as MyApp).component())
            .viewModelModule(ViewModelModule(this))
            .build().inject(this)
    }
}