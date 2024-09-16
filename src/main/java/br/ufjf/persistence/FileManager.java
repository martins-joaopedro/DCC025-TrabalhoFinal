package br.ufjf.persistence;

import br.ufjf.models.Usuario;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    Gson gson = new Gson();

    public void write() throws IOException {
        FileWriter writer = new FileWriter("teste.json");
        String json = gson.toJson(new Usuario("A", "a"));
        System.out.println(json);
        writer.write(json);
    }

    public void load() throws IOException {

    }

}
