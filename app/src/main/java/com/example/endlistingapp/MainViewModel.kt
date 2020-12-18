package com.example.endlistingapp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.endlistingapp.model.ListingModel
import com.example.endlistingapp.repository.Repository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(private val repo: Repository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _listing = MutableLiveData<ApiResponse>()

    fun getListingResult(): LiveData<ApiResponse> = _listing

    fun getItemListing() {
        viewModelScope.launch {
            try {
                repo.fetchListing().apply {
                    _listing.value = ApiResponse.Success(body = this)
                }
            } catch (e: Throwable) {
                _listing.value = ApiResponse.Error(e.localizedMessage)
            }
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}

sealed class ApiResponse {
    data class Success(val body: ListingModel) : ApiResponse()
    data class Error(val error: String) : ApiResponse()
}