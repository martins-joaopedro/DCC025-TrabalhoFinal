# DCC025-TrabalhoFinal
repositório do trabalho final da disciplina de orientação a objetos 

``` mermaid
classDiagram

Acervo *-- Livro
Biblioteca
 Leitor

Livro
Biblioteca


class Livro {
    -String nome
    -String autor
    -String ISBN
    -String sinopse
    -int paginas
    -Genero genero 
    -Avaliacao avaliacao
    -Status status
}

class Genero {
    <<enumeration>>
    Fantasia
    Romance
    Ficção
    Academico
    Distopia
    Suspense
    Terror
}

class Acervo {
    -Livro[] livros
}

class Avaliacao {
    -int estrelas
    -String comentario
}

class Status {
    <<enumeration>>
    Lendo
    Lido
    Pretendo ler
}

class Leitor {
    -String nome
    -String idade
    -Biblioteca biblioteca
}

class Biblioteca {
    -Livros[] livros

    -addLivro()
    -removerLivro()
    -editarLivro()

    -int calcTotalPaginas
    -String calcGeneroMaisLido
    -listarHistorico
}

class Administrador {
    -addLivro()
    -removerLivro()
    -editarLivro()
}

```
