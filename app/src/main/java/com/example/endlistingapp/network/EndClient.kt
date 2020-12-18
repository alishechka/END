package com.example.endlistingapp.network

import com.example.endlistingapp.common.ENDPOINT_LISTING
import com.example.endlistingapp.model.ListingModel
import io.reactivex.Single
import retrofit2.http.GET

interface EndClient {
    @GET(ENDPOINT_LISTING)
    suspend fun getCurrentListing(): ListingModel
}