package br.ufjf.utils;

import br.ufjf.exceptions.ParserExceptions;

public class InputParser {

    public static int toInteger(String pages, int max) throws ParserExceptions {
        int value = Integer.parseInt(pages);

        if(pages.matches("[A-Z]*"))
            throw new ParserExceptions("Informe um valor numérico");

        if(value < 0 || value > max)
            throw new ParserExceptions("Informe um valor válido");
        else return value;
    }
}
