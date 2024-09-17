# DCC025-TrabalhoFinal
repositório do trabalho final da disciplina de orientação a objetos 

``` mermaid
classDiagram 

Livro <|-- LivroPessoal
Avaliacao *-- Livro
Usuario <|-- Administrador
Usuario <|-- Leitor

class Livro {
    - nome : String
    - autor : String
    - ISBN : String 
    - sinopse : String 
    - paginas : int 
    - genero : Genero 
}

class LivroPessoal {
    - status : Status
    - paginaAtual : int
}

class Avaliacao {
    - ISBN : String
    - idLeitor : String 
    - estrelas : int
    - comentario : String
}

class Leitor {
    - nome : String
    - bibliotecaPessoal : Map<String, Livro> 
}

class Usuario {
    - idUsuario : String
    - senha : String
}

class BibliotecaServico {
    - livrosUsuario : Map<String, LivroUsuario> 
    
    + getGeneroMaisLido() : Genero
    + getNumTotalPaginasLidas() : int  
    + getNumLivrosLidos() : int
    + adicionarLivro()
    + removerLivro()
    + editarLivro()
    + atualizarAvaliacao()
    + getLivroStatus() : List<LivroUsuario>
    + getLivrosAvaliados() : List<LivroUsuario>
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

class Status {
    <<enumeration>>
    Lendo
    Lido
    Pretendo ler
    Abandonei
}

class Administrador
```
