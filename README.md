# DCC025-TrabalhoFinal
repositório do trabalho final da disciplina de orientação a objetos 

``` mermaid
classDiagram 

Acervo *-- Livro

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
    Abandonei
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
    -int numLivrosLidos
    -String calcGeneroMaisLido
    -listarHistorico
}

class Administrador {
    -addLivro()
    -removerLivro()
    -editarLivro()
}
```


** Diagrama das Telas
``` mermaid
classDiagram


class Administrador{
     - void AdicionarLivro()
     - void RemoverLivro()
     - void EditarLivro()
}

class NavigationConstants {
    Screen static Home
    Screen static Login
    Screen static BibliotecaDoUsuario
    Screen static Catalogo
    Screen static AdicionarStatusLivro
    Screen static AtualizarStatus
    Screen static AvaliacaoLivro
}

class Manager {
    -Window window
    -Map<String, Screen> screens
    +start()
    +navigateTo(String screenName)
    +createScreens(Map<String, Screen> screens)
}

JFrame <|-- Window
class JFrame 

class Window {
    +Manager manager
    +static int WIDTH
    +static int HEIGHT
    -JPanel mainPanel
    -CardLayout layout
    +addScreen(String panelName, JPanel panel)
    +showPanel(String panelName)
    +start
}

JPanel <|-- Screen

JPanel <|-- PainelHome
JPanel <|-- PainelLogin
JPanel <|-- PainelBibliotecaDoUsuario
JPanel <|-- PainelCatalogo
JPanel <|-- PainelAdicionarStatusLivro
JPanel <|-- PainelAtualizarStatus
JPanel <|-- PainelAvaliacaoLivro

class JPanel 

class Screen {
    JTextField title
    JPanel mainPanel
    JButton navigator
}

class PainelHome 
class PainelLogin 
class PainelBibliotecaDoUsuario 
class PainelCatalogo 
class PainelAdicionarStatusLivro
class PainelAtualizarStatus
class PainelAvaliacaoLivro
```

