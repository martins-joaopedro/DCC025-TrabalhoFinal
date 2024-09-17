package br.ufjf.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import br.ufjf.exceptions.CouldNotConvertJsonException;
import br.ufjf.models.Usuario;
import br.ufjf.persistence.FileManager;
import br.ufjf.utils.JsonConverter;

public class LoginService implements IService<Usuario> {
    
    String path = "users.json";

    @Override
    public Usuario findById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> findAll() {

        String data = FileManager.load(path);
        List<Usuario> users = new ArrayList<>();
        Type type = new TypeToken<List<Usuario>>(){}.getType();
        
        try {
            users = new ArrayList<>(JsonConverter.convertDataIntoList(data, type));
            System.out.println(users); 
        } catch (CouldNotConvertJsonException e) {
            System.out.println(e.getMessage());
        }    

        return users;    
    }

    @Override
    public void create(Usuario obj) {
        FileManager.append(path, obj);
    }

    @Override
    public void saveAll(List<Usuario> obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clearAll() {
        FileManager.clear(path);
    }
    
}
