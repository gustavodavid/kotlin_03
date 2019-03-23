package gustavo.kotlin_03.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import gustavo.kotlin_03.Entidade.Filme
import gustavo.kotlin_03.R
import retrofit2.http.GET
import java.util.regex.Pattern

class FilmeAdapter(val context:Context, val dados:ArrayList<Filme>): RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    private val inflater:LayoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = this.inflater.inflate(R.layout.filme_list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.dados.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val filme = this.dados.get(position)

        viewHolder.filmeTitulo.text = filme.titulo
        viewHolder.filmeData.text = filme.data_lancamento
        viewHolder.filmeDuracao.text = Pattern.compile("${filme.hora}h:${filme.minuto}m").toString()

        if (filme.poster.trim().length > 0 && filme.poster.isNotBlank()) {
            Picasso.get()
                .load(filme.poster)
                .placeholder(R.drawable.procurando)
                .into(viewHolder.filmePoster)
        } else {
            Picasso.get()
                .load(R.drawable.procurando)
                .into(viewHolder.filmePoster)
        }
    }

    class ViewHolder(val view:View): RecyclerView.ViewHolder(view){

        val filmePoster:ImageView
        val filmeTitulo:TextView
        val filmeData:TextView
        val filmeDuracao:TextView

        init {
            this.filmePoster = this.view.findViewById(R.id.filme_list_item_poster)
            this.filmeTitulo = this.view.findViewById(R.id.filme_list_item_titulo)
            this.filmeData = this.view.findViewById(R.id.filme_list_item_data_lancamento)
            this.filmeDuracao = this.view.findViewById(R.id.filme_list_item_duracao)
        }
    }

}