package com.example.endlistingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.endlistingapp.model.ListingModel
import com.example.endlistingapp.repository.Repository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class MainViewModel(private val repo: Repository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val listingSuccess = MutableLiveData<ListingModel>()
    private val error = MutableLiveData<String>()

    fun getListingSuccess(): LiveData<ListingModel> = listingSuccess
    fun getError(): LiveData<String> = error

    fun getItemListing() {
        compositeDisposable.add(
            repo.fetchListing().subscribe(
                { listing -> listingSuccess.value = listing
                Timber.d(listing.title)},
                { e -> error.value = e.localizedMessage
                Timber.d(e.localizedMessage)}
            )
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}