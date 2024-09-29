package br.ufjf.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileManager {

    // usamos a factory para adicionar de forma formatada 
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static String mainPath = "content";

    public static void write(String path, Object data) {

        String fullPath = mainPath + File.separator + path;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath, false))) {
            if(data != "" && data != null) {
                String json = gson.toJson(data);
                writer.write(json);
            } else writer.write("");
        } catch (IOException e) {
            System.out.println("ERRO: Problema ao escrever arquivo");
        }
    }

    public static String load(String path) {
       
        String fullPath = mainPath + File.separator + path;

        String data = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
            
            String line;
            while ((line = reader.readLine()) != null)
                data += line + "\n";
        
        } catch (Exception e) {
            System.out.println("ERRO: Problema ao ler arquivo");
        }
        return data;
    }

    public static void append(String path, Object obj) {
        
        List<Object> list;
        String savedData = load(path);

        Type type = new TypeToken<List<Object>>(){}.getType();
        
        if(savedData != null && !savedData.isEmpty())
            list = gson.fromJson(savedData, type);
        else list = new ArrayList<>();
        
        list.add(obj);
        write(path, list);
    }

    public static void clear(String path) {
        write(path, "");
    }
}