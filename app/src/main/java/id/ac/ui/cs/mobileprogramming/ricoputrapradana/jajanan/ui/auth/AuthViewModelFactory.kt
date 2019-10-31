package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.repository.UserRepository

/**
 * To pass parameter UserRepository object in instantiating AuthViewModel
 */
@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T: ViewModel?> create(modelClass: Class<T>) : T {
        return AuthViewModel(repository) as T
    }
}