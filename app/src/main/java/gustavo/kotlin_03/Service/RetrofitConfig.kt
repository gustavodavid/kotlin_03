package gustavo.kotlin_03.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    var retrofit: Retrofit? = null

    fun RetrofitConfig() {
        this.retrofit = Retrofit.Builder()
            .baseUrl("http://demo3200731.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getFilmesService(): FilmeService {
        if(this.retrofit == null) {
            this.RetrofitConfig()
        }
        return this.retrofit!!.create(FilmeService::class.java)
    }
}