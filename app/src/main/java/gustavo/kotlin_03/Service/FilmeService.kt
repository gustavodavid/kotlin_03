package gustavo.kotlin_03.Service

import gustavo.kotlin_03.Entidade.Filme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

interface FilmeService {

    @GET("v2/filmes")
    fun listarFilmes(): Call<ArrayList<Filme>>

}

interface FilmeServiceResponse {
    fun getFilmesSuccess(filmes:ArrayList<Filme>)
    fun getFilmesFailure(erro:String)
}

class FilmeServiceCall {
    fun getFilmes(context:FilmeServiceResponse) {
        var call:Call<ArrayList<Filme>> = RetrofitConfig().getFilmesService().listarFilmes()
        call.enqueue( object: Callback<ArrayList<Filme>> {
            override fun onFailure(call: Call<ArrayList<Filme>>, t: Throwable) {
                context.getFilmesFailure(t.message!!)
            }
            override fun onResponse(call: Call<ArrayList<Filme>>, response: Response<ArrayList<Filme>>) {
                context.getFilmesSuccess(response.body()!!)
            }
        })
    }

}
