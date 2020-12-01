package com.example.endlistingapp.repository

import com.example.endlistingapp.model.ListingModel
import com.example.endlistingapp.network.EndClient
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val client: EndClient) : Repository {
    override fun fetchListing(): Single<ListingModel> {
        return client.getCurrentListing()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}