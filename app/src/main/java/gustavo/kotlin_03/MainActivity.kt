package gustavo.kotlin_03

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import gustavo.kotlin_03.Adapter.FilmeAdapter
import gustavo.kotlin_03.Entidade.Filme
import gustavo.kotlin_03.Service.FilmeServiceCall
import gustavo.kotlin_03.Service.FilmeServiceResponse
import gustavo.kotlin_03.Service.RetrofitConfig


class MainActivity : AppCompatActivity(), FilmeServiceResponse {

    lateinit var mainRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.mainRecyclerView = this.findViewById(R.id.main_recycler_view)
        this.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        FilmeServiceCall().getFilmes(this)
    }

    private fun atualizarDadosRecyclerView(filmes: ArrayList<Filme>) {
        this.mainRecyclerView.adapter = FilmeAdapter(this, filmes)
    }

    override fun getFilmesSuccess(filmes: ArrayList<Filme>) {
        this.atualizarDadosRecyclerView(filmes)
    }

    override fun getFilmesFailure(erro: String) {
        this.atualizarDadosRecyclerView(ArrayList())
    }

}
