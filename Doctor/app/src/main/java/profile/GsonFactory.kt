package profile

import com.google.gson.GsonBuilder

object GsonFactory {
    fun build() = GsonBuilder().create()
}