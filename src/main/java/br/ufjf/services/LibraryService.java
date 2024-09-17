package br.ufjf.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufjf.models.Livro;
import br.ufjf.persistence.FileManager;

public class LibraryService implements IService<Livro>{
    
    Gson gson = new Gson();
    String path = "books.json";

    @Override
    public Livro findById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Livro> findAll() {
        String data = FileManager.load(path);
        List<Livro> books;
        if(!data.isEmpty()) {
            Type type = new TypeToken<List<Livro>>(){}.getType();
            books = new ArrayList<>(gson.fromJson(data, type));
            return books;
        } else return new ArrayList<>();
    }

    @Override
    public void create(Livro obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveAll(List<Livro> obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
