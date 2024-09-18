package com.petproject.hiltfullguide

import androidx.lifecycle.ViewModel
import com.petproject.hiltfullguide.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ViewModelHilt @Inject constructor(
    @Named("repositoryAnother")
    private val repository: Repository
) : ViewModel() {

    fun userName(): String {
        return repository.userName()
    }
}