package app.adon.kmplab.data.fakers

import app.adon.kmplab.domain.entity.Book

object BookFaker {
    fun generate(qty: Int): List<Book> = (1..qty).map { i ->
        Book(
            id = "id_$i",
            name = "Livro $i",
            author = "Ninguem, carai"
        )
    }
}