package profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: UserRepository = UserRepository.instance): ViewModel() {

    private val _profile = MutableLiveData<ProfileItem>()
    val profile : LiveData<ProfileItem>
        get() = _profile

    private val _loading = MutableLiveData(false)
    val loading : LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData(false)
    val error : LiveData<Boolean>
        get() = _error

    fun loadProfile(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchProfile()
                .onStart{_loading.postValue(true)}
                .catch{_error.postValue(true)}
                .onCompletion{_loading.postValue(false)}
                .collect{
                    _profile.value = it.results.first()
                }
        }
    }
}