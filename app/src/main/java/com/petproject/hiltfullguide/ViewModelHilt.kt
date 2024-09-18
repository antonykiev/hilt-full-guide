package com.petproject.hiltfullguide

import androidx.lifecycle.ViewModel
import com.petproject.hiltfullguide.repository.Repository
import dagger.Lazy
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Named

@AssistedFactory
internal interface ViewModelHiltFactory {
    fun create(userId: Int): ViewModelHilt
}

@HiltViewModel(assistedFactory = ViewModelHiltFactory::class)
class ViewModelHilt @AssistedInject constructor(
    @Assisted
    private val userId: Int,
    @Named("repositoryAnother")
    private val repository: Lazy<Repository>
) : ViewModel() {

    fun userName(): String {
        return repository.get().userName()
    }

}