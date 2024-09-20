package br.ufjf.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import br.ufjf.exceptions.CouldNotConvertJsonException;
import br.ufjf.models.User;
import br.ufjf.persistence.FileManager;
import br.ufjf.utils.JsonConverter;

public class LoginService implements IService<User> {
    
    String path = "users.json";

    @Override
    public User findById(String id) {
        //throw new UnsupportedOperationException("Not supported yet.");
        
        String data = FileManager.load(path);
        List<User> users = new ArrayList<>();
        Type type = new TypeToken<List<User>>(){}.getType();
        
        try {
            users = new ArrayList<>(JsonConverter.convertDataIntoList(data, type));
            System.out.println(users); 
        } catch (CouldNotConvertJsonException e) {
            System.out.println(e.getMessage());
        }    

        for (User usuario : users) {
            if (usuario.getUsername().equals(id))
                return usuario;
        }

        return null;
    }

    @Override
    public List<User> findAll() {

        String data = FileManager.load(path);
        List<User> users = new ArrayList<>();
        Type type = new TypeToken<List<User>>(){}.getType();
        
        try {
            users = new ArrayList<>(JsonConverter.convertDataIntoList(data, type));
            System.out.println(users); 
        } catch (CouldNotConvertJsonException e) {
            System.out.println(e.getMessage());
        }    

        return users;    
    }

    @Override
    public void create(User obj) {
        FileManager.append(path, obj);
    }

    @Override
    public void saveAll(List<User> obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clearAll() {
        FileManager.clear(path);
    }
    
}
