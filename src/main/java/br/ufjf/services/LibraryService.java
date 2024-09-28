package br.ufjf.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;
import br.ufjf.persistence.FileManager;

public class LibraryService implements IService<Book>{
    
    Gson gson = new Gson();
    String path = "books.json";

    private static PersonalLibraryService personalLibraryService = new PersonalLibraryService();

    @Override
    public Book findById(String id) {
        List<Book> books = findAll();
        for(Book book : books)
            if(book.getISBN().equalsIgnoreCase(id))
                return book;
        return null;
    }

    @Override
    public List<Book> findAll() {
        String data = FileManager.load(path);
        List<Book> books;
        if(!data.isEmpty()) {
            Type type = new TypeToken<List<Book>>(){}.getType();
            books = new ArrayList<>(gson.fromJson(data, type));
            return books;
        } else return new ArrayList<>();
    }

    public List<Book> getBooksByGenre(Genre genre) {
        List<Book> books = findAll();
        List<Book> genreBooks = new ArrayList<>();

        for(Book book : books)
            if(book.getGenre().equals(genre) && !personalLibraryService.isOnPersonalLibrary(book.getISBN()))
                genreBooks.add(book);
        
        return genreBooks;
    }

    @Override
    public void create(Book obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveAll(List<Book> obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
