package gustavo.kotlin_03.Entidade

data class Filme (

    var id:String = "",
    var titulo:String = "",
    var data_lancamento:String = "",
    var hora:String = "",
    var minuto:String = "",
    var poster:String = ""
    )

//class Filme {
//
//    var id:String = ""
//    var titulo:String = ""
//    var data_lancamento:String = ""
//    var hora:String = ""
//    var minuto:String = ""
//    var poster:String = ""
//
//    constructor() {
//
//    }
//
//    constructor(id: String, titulo: String, data_lancamento: String, hora: String, minuto: String, poster: String) {
//        this.id = id
//        this.titulo = titulo
//        this.data_lancamento = data_lancamento
//        this.hora = hora
//        this.minuto = minuto
//        this.poster = poster
//    }
//
//    override fun toString(): String {
//        return "id: ${this.id}" +
//                "título: ${this.titulo}" +
//                "data lançamento: ${this.data_lancamento}" +
//                "duração: ${this.hora}h:${this.minuto}" +
//                "poster: ${this.poster}"
//    }
//
//}