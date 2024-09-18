package com.petproject.hiltfullguide

import androidx.lifecycle.ViewModel
import com.petproject.hiltfullguide.repository.Repository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ViewModelHilt @Inject constructor(
    @Named("repositoryAnother")
    private val repository: Lazy<Repository>
) : ViewModel() {

    fun userName(): String {
        return repository.get().userName()
    }
}