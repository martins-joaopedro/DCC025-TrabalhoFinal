package br.ufjf.utils;

import br.ufjf.exceptions.ParserExceptions;

public class InputParser {

    public static int toInteger(String pages, int max) throws ParserExceptions {
        int value = Integer.parseInt(pages);

        if(pages.contains("[a-Z]*"))
            throw new ParserExceptions("Informe um valor numérico");

        if(value < 0) 
            if(max != -1)
                if(value > max)
                    throw new ParserExceptions("Informe um menor que o total de páginas.");
            else throw new ParserExceptions("Informe um valor válido!");
        return value;
    }
}
