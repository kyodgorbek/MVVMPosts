package gahfy.net.base

import androidx.lifecycle.ViewModel
import gahfy.net.injection.component.DaggerViewModelInjector
import gahfy.net.injection.component.ViewModelInjector
import gahfy.net.injection.module.NetworkModule
import gahfy.net.ui.post.PostListViewModel


abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}