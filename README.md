# DCC025-TrabalhoFinal
repositório do trabalho final da disciplina de orientação a objetos 

``` mermaid
classDiagram 

Book <|-- PersonalBook 
Review *-- Book
Status o-- PersonalBook
AdmService o-- Book
User <|-- Reader
User o-- Review
Reader o-- PersonalBook
IService <|.. LibraryService
IService <|.. LoginService
IService <|.. PersonalLibraryService
IService <|.. ReviewService
IService <|.. AdmService


class PersonalBookDTO {
    + PersonalBookDTO() : record
}

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
    - displayName : String

    + fromDisplayName() : Status
}

class Review {
    - id : String
    - username : String
    - ISBN : String
    - stars : int
    - comment : String
}

class Reader 

class User {
    - username : String
    - password : String
}

class FileManager {
    + write()
    + load() : String
    + append()
    + clear()   
}

class IService {
    <<interface>>

    + findById() : T
    + findAll() : List<T> 
    + create()
    + saveAll()
}

class AdmService {
    + findById() : Book
    + findAll() : List<Book>
    + create()
    + saveAll()
    + update()
    + addBook()
    + removeBook()
}

class LibraryService {
    + findById() : Book
    + findAll() : List<Book>
    + create()
    + saveAll()
    + getBooksByGenre : List <Book>
}

class LoginService {
    + findById() : User
    + findAll() : LIst<User>
    + create()
    + saveAll()
    + clearAll()
}

class PersonalLibraryService {
    + findById() : PersonalBookDTO ATENcAOO
    + findAll() : List<PersonalBookDTO>
    + create()
    + saveAll()
    + addToPersonalLibrary()
    + getAllAsPersonalBooks() : List<PersonalBook>
    + isOnPersonalLibrary() : boolean
    + removeFromPersonalLibrary()
    + getBooksByStatus() : List<PersonalBook>
    + getNumTotalPaginasLidas() : int
    + getNumLivrosLidos() : int
    + getGenreMaisLido() : Genre 
}

class ReviewService {
    + findById() : Review
    + findAll() : List<Review>
    + create()
    + saveAll()
    + getReviewsByISBN() : List<Review>
    + getUserReviewByISBN : Review
    + removeUserReview()
}
```
