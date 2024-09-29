package br.ufjf.services;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufjf.exceptions.LibraryException;
import br.ufjf.models.Book;
import br.ufjf.persistence.FileManager;

public class AdmService implements IService<Book> {

    Gson gson = new Gson();
    String path = "books.json";

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

    @Override
    public void create(Book book) {
        FileManager.append(path, book);
    }

    @Override
    public void saveAll(List<Book> obj) {

    }

    public void update(Book receivedBook) throws LibraryException {
        List<Book> books = findAll();
        boolean isFound = false;
        for(Book book : books) {
            if(book.getISBN().equalsIgnoreCase(receivedBook.getISBN())) {
                books.remove(book);
                books.add(receivedBook);
                isFound = true;
                break;
            }
        }
        if(isFound)
            FileManager.write(path, books);
        else throw new LibraryException("Nenhum livro encontrado com esse ISBN");
    }

    public void addBook(Book book) throws LibraryException {
        if(findById(book.getISBN()) != null)
            throw new LibraryException("Já existe um livro com esse ISBN!");
        else FileManager.append(path, book);
    }

    public void removeBook(Book receivedBook) throws LibraryException {
        List<Book> books = findAll();
        boolean isFound = false;
        for(Book book : books) {
            if(book.getISBN().equalsIgnoreCase(receivedBook.getISBN())) {
                books.remove(book);
                isFound = true;
                break;
            }
        }
        if(isFound)
            FileManager.write(path, books);
        else throw new LibraryException("Não existe um livro com esse ISBN!");
    }
}
