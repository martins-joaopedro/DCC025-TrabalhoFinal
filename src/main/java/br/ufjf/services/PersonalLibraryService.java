package br.ufjf.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.Library;
import br.ufjf.interfaces.PersonalLibrary;
import br.ufjf.models.Book;
import br.ufjf.models.PersonalBook;
import br.ufjf.models.dto.PersonalBookDTO;
import br.ufjf.models.enums.Genre;
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

    public void addToPersonalLibrary(String ISBN, String user, Status status) {
        create(new PersonalBookDTO(ISBN, user, status, 0));
        AplicationWindow.reloadScreen(new Library(), "library");
        AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
    }

    public List<PersonalBook> getAllAsPersonalBooks() {
        List<PersonalBookDTO> dtos = findAll();
        List<PersonalBook> books = new ArrayList<>();

        for(PersonalBookDTO dto : dtos) {
            Book book = service.findById(dto.ISBN());
            if(book != null && dto.user().equals(AplicationWindow.getUser()))
                books.add(new PersonalBook(book, dto.user(), dto.status(), dto.currentPage()));
        }
        return books;
    }

    public boolean isOnPersonalLibrary(String id) {
        List<PersonalBookDTO> dtos = findAll();
        for(PersonalBookDTO dto : dtos)
            if(dto.ISBN().equalsIgnoreCase(id))
                return true;
        return false;
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
        AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
    }

    public List<PersonalBook> getBooksByStatus(Status status) {
        List<PersonalBook> listBookByStatus = new ArrayList<>();

        for(PersonalBook book : this.getAllAsPersonalBooks())
            if(book.getStatus() == status)
                listBookByStatus.add(book);

        return listBookByStatus;
    }

    public int getNumTotalPaginasLidas() {
        int numTotalPaginas = 0;

        for(PersonalBook book : this.getAllAsPersonalBooks()) {
            if(book.getStatus() == Status.LIDO)
                numTotalPaginas+=book.getPages();
            if(book.getStatus() == Status.LENDO)
                numTotalPaginas+=book.getCurrentPage();
        }

        return numTotalPaginas;
    }

    public int getNumLivrosLidos() {
        int numLivrosLidos = 0;

        for(PersonalBook book : this.getAllAsPersonalBooks()) {
            if(book.getStatus() == Status.LIDO)
                numLivrosLidos++;
        }

        return numLivrosLidos;
    }

    public Genre getGenreMaisLido() {
        Map<Genre, Integer> readGenres = new HashMap<>();
        
        for(PersonalBook book : this.getAllAsPersonalBooks()) {
            if(book.getStatus() == Status.LIDO) {
                Genre genre = book.getGenre();
                System.out.println(genre.toString());

                try {
                    if(readGenres.containsKey(genre))
                        readGenres.put(genre, readGenres.get(genre)+1);
                    else
                        readGenres.put(genre, 1);
                } catch (NullPointerException e) {
                    System.out.println("Genero do livro não encontrado");
                    try {
                        System.out.println("Livro:" + book.getName());
                    } catch (NullPointerException e2) {
                        System.out.println("Livro com erro");
                    }
                }
            }
        }
        
        Genre genreMaisLido = null;
        int max = 0;
        for(Genre genre : readGenres.keySet()) {
            if(readGenres.get(genre) > max) {
                genreMaisLido = genre;
                max = readGenres.get(genre);
            }
        }

        return genreMaisLido;
    }

   
/*
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
