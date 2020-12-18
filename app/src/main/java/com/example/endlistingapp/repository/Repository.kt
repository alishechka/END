package com.example.endlistingapp.repository

import com.example.endlistingapp.model.ListingModel
import io.reactivex.Single

interface Repository {
    suspend fun fetchListing(): ListingModel
}