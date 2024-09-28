# DCC025-TrabalhoFinal
repositório do trabalho final da disciplina de orientação a objetos 

``` mermaid
classDiagram 

Book <|-- PersonalBook
Review *-- Book
User <|-- Adm
User <|-- Reader

class Book {
    - name : String
    - author : String
    - ISBN : String 
    - synopsis : String 
    - pages : int 
    - genre : Genre
}

class PersonalBook {
    - status : Status
    - user : String
    - currentPage : int
}

class Review {
    - id : String
    - username : String
    - ISBN : String
    - stars : int
    - comment : String
}

class Reader {
    - name : String
    - personalLibrary : Map<String, Book> 
}

class User {
    - username : String
    - password : String
}

class BibliotecaServico {
    - livrosUsuario : Map<String, LivroUsuario> 
    
    + adicionarLivro()
    + removerLivro()
    + editarLivro()
    + atualizarAvaliacao()   
}

class Genre {
    <<enumeration>>
    Fantasia
    Romance
    Ficção
    Academico
    Distopia
    Suspense
    Literatura_Juvenil
    Ficcao_Cientifica
    Misterio
    Horror
    - type : String
}

class Status {
    <<enumeration>>
    Lendo
    Lido
    Quero_Ler
    Abandonei
    - dispalyName : String

    + fromDisplayName() : Status
    
    
    
}
```
