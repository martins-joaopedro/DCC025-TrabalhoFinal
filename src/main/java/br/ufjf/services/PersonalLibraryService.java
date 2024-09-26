package br.ufjf.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufjf.models.Book;
import br.ufjf.models.PersonalBook;
import br.ufjf.models.dto.PersonalBookDTO;
import br.ufjf.models.enums.Status;
import br.ufjf.persistence.FileManager;

public class PersonalLibraryService implements IService<PersonalBookDTO> {

    LibraryService service = new LibraryService();

    Gson gson = new Gson();
    String path = "library.json";

    @Override
    public PersonalBookDTO findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PersonalBookDTO> findAll() {
        String data = FileManager.load(path);
        List<PersonalBookDTO> books;
        if(!data.isEmpty()) {
            var type = new TypeToken<List<PersonalBookDTO>>(){}.getType();
            books = new ArrayList<>(gson.fromJson(data, type));
            return books;
        } else return new ArrayList<>();
    }

    @Override
    public void create(PersonalBookDTO obj) {
        FileManager.append(path, obj);
    }

    @Override
    public void saveAll(List<PersonalBookDTO> obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    public void addToPersonalLibrary(String ISBN) {
        create(new PersonalBookDTO(ISBN, Status.ABANDONEI, 0));
    }

    public List<PersonalBook> getAll() {
        List<PersonalBookDTO> dtos = findAll();
        List<PersonalBook> books = new ArrayList<>();

        for(PersonalBookDTO dto : dtos) {
            Book book = service.findById(dto.ISBN());
            System.out.println(book);
            if(book != null)
                books.add(new PersonalBook(book, dto.status(), dto.currentPage()));
        }

        System.out.println("TODOS");
        return books;
    }

    public void removeFromPersonalLibrary(String id) {
        List<PersonalBookDTO> dtos = findAll();
        for(PersonalBookDTO dto : dtos) {
            if(dto.ISBN().equalsIgnoreCase(id)) {
                dtos.remove(dto);
                break;
            }
        }
        FileManager.write(path, dtos);
    }

    public void updateBook(PersonalBookDTO book) {
        List<PersonalBookDTO> dtos = findAll();
        for(PersonalBookDTO dto : dtos) {
            if(dto.ISBN().equalsIgnoreCase(book.ISBN())) {
                dtos.remove(dto);
                dtos.add(book);
                break;
            }
        }
        FileManager.write(path, dtos);
    }

   
/*
    public Genre getGenreMaisLido() {
        Map<Genre, Integer> readGenres = new HashMap<>();

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == Status.LIDO) {
                Genre GenreLivro = Biblioteca.buscaLivro(livroUsuario.getIBSN()).getGenre();
                
                if(readGenres.containsKey(GenreLivro))
                    readGenres.put(GenreLivro, readGenres.get(GenreLivro)+1);
                else
                    readGenres.put(GenreLivro, 0);
            }
        }

        Genre GenreMaisLido = Genre.ACADEMICO;
        for(Genre Genre : readGenres.keySet()) {
            if(readGenres.get(Genre) > readGenres.get(GenreMaisLido))
                GenreMaisLido = Genre;
        }

        return GenreMaisLido;
    }

    public int getNumTotalPaginasLidas() {
        int numTotalPaginas = 0;

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == Status.LIDO)
                numTotalPaginas+=Biblioteca.buscaLivro(livroUsuario.getIBSN()).getPaginas();
            if(livroUsuario.getStatus() == Status.LENDO)
                numTotalPaginas+=livroUsuario.getNumPaginasLidas();
        }

        return numTotalPaginas;
    }

    public int getNumLivrosLidos() {
        int numLivrosLidos = 0;

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == Status.LIDO)
                numLivrosLidos++;
        }

        return numLivrosLidos;
    }

    public void addLivro(String ISBN, Status status) {
        if(this.livrosUsuario.containsKey(ISBN)) {
            // ERRO DE QUE O LIVRO JÁ ESTÁ NO ACERVO PESSOAL
        }
        else
            this.livrosUsuario.put(ISBN, new LivroUsuario(ISBN, status));
    }

    public void removerLivro(String ISBN) {
        if(!this.livrosUsuario.containsKey(ISBN)) {
            // ERRO DE QUE O LIVRO NÃO ESTÁ NO ACERVO PESSOAL
        }
        else
            this.livrosUsuario.remove(ISBN);
    }

    public void editarLivro(String ISBN, Status status, int numPaginasLidas) {
        if(!this.livrosUsuario.containsKey(ISBN)) {
            // ERRO DE QUE O LIVRO NÃO ESTÁ NO ACERVO PESSOAL
        }
        
        LivroUsuario livroAtualizado = livrosUsuario.get(ISBN);
        livroAtualizado.atualizarStatus(status);
        if(status == Status.LENDO)
            livroAtualizado.atualizarNumPaginasLidas(numPaginasLidas);
        this.livrosUsuario.put(ISBN, livroAtualizado);
    }

    public void atualizarAvaliacao(String ISBN, int estrela, String comentario) {
        if(!this.livrosUsuario.containsKey(ISBN)) {
            // ERRO DE QUE O LIVRO NÃO ESTÁ NO ACERVO PESSOAL
        }
        
        LivroUsuario livroAtualizado = livrosUsuario.get(ISBN);
        livroAtualizado.avaliarLivro(estrela, comentario);
        this.livrosUsuario.put(ISBN, livroAtualizado);
    }

    public List<LivroUsuario> getLivrosStatus(Status status) {
        List<LivroUsuario> listaLivrosUsuario = new ArrayList<>();

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == status)
                listaLivrosUsuario.add(livroUsuario);
        }

        return listaLivrosUsuario;
    }

    public List<LivroUsuario> getLivrosAvaliados() {
        List<LivroUsuario> listaLivrosAvaliados = new ArrayList<>();

        for(LivroUsuario livroUsuario : getLivrosStatus(Status.LIDO)) {
            if(livroUsuario.getAvaliacao() != null) {
                listaLivrosAvaliados.add(livroUsuario);
            }
        }

        return listaLivrosAvaliados;
    }
 */
}
