package io.keepcoding.photomars.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.keepcoding.photomars.ui.detail.DetailViewModel
import io.keepcoding.photomars.ui.main.fragments.FavoritesViewModel
import io.keepcoding.photomars.ui.main.fragments.MainFragmentViewModel
import java.lang.IllegalArgumentException

class CustomViewModelFactory(private val application: Application) :
        ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(MainFragmentViewModel::class.java) -> MainFragmentViewModel(application)
                isAssignableFrom(FavoritesViewModel::class.java) -> FavoritesViewModel(application)
                isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(application)
                else -> throw IllegalArgumentException("Unknown ViewModel")
            }
        } as T
    }
}

