package br.ufjf.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import br.ufjf.models.Livro;
import br.ufjf.persistence.FileManager;

public class LibraryService {
    
    Gson gson = new Gson();
    String path = "books.json";

    public List<Livro> loadAllBooks() {

        String data = FileManager.load(path);
        List<Livro> books;
        if(!data.isEmpty()) {
            Type type = new TypeToken<List<Livro>>(){}.getType();
            books = new ArrayList<>(gson.fromJson(data, type));
            return books;
        } else return new ArrayList<>();
    }
}
