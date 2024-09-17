package br.ufjf.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;

import br.ufjf.exceptions.CouldNotConvertJsonException;

public class JsonConverter {

    static Gson gson = new Gson();

    public static <T> T convertDataIntoList(String data, Type type) throws CouldNotConvertJsonException {
        if(!data.isEmpty() && data != null) 
            return gson.fromJson(data, type);
        else throw new CouldNotConvertJsonException("ERRO: Dados inválidos para a conversão");
    }
}