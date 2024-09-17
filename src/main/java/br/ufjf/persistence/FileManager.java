package br.ufjf.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class FileManager {

    static Gson gson = new Gson();
    static String mainPath = "content/";

    public static void write(String path, Object data) {

        String fullPath = mainPath + File.separator + path;

        String json = gson.toJson(data);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath, false))) {
            writer.write(json);
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
}
