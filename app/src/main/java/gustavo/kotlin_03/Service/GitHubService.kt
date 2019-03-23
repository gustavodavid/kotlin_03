package gustavo.kotlin_03.Service

import gustavo.kotlin_03.Entidade.Filme
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GitHubService {

    @GET("/v2/filmes")
    fun listarFilmes(): Call<List<Filme>>

    companion object Factory {
        fun create(): GitHubService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://demo3200731.mockable.io/")
                .build()

            return retrofit.create(GitHubService::class.java);
        }
    }
}