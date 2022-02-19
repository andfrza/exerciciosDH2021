package profile

import androidx.constraintlayout.helper.widget.Flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository(private val api: Api = Api.instance) {
    fun fetchProfile(): Flow<ProfileResponse> = flow<ProfileResponse> {
        emit(api.getProfile())
    }.flowOn(Dispatchers.IO)

    companion object{
        val instance by lazy{UserRepository()}
    }
}
// TODO: 18/02/2022 Verificar o que é ProfileResponse; a instância da interface Api; a função emit e o conteúdo da função getProfile().