package com.example.endlistingapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.example.endlistingapp.model.ListingModel
import com.example.endlistingapp.repository.Repository
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var sut: MainViewModel

    @Mock
    private lateinit var repo: Repository

    private lateinit var model: ListingModel

    @Before
    fun setup() {
        sut = MainViewModel(repo)
        model = listingModel
    }

    @Test
    fun `calling viewModel will call appropriate fun in repo`() {
        //given
        given(repo.fetchListing()).willReturn(Single.just(model))

        //when
        sut.getItemListing()

        //then
        verify(repo, times(1)).fetchListing()
        Mockito.verifyNoMoreInteractions(repo)
    }

    @Test
    fun `assert that data received has not been transformed`() {
        //given
        given(repo.fetchListing()).willReturn(Single.just(model))

        //when
        sut.getItemListing()
        val liveData: LiveData<ListingModel> = sut.getListingSuccess()

        //then
        assertThat(liveData.value).isSameAs(model)
    }


}