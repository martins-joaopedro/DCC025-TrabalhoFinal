package br.ufjf.utils;

import br.ufjf.exceptions.ParserExceptions;
import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;

public class InputParser {

    public static int toInteger(String pages, int max) throws ParserExceptions {
        if(!pages.matches("[0-9]+"))
            throw new ParserExceptions("Informe um valor numérico");
        
        int value = Integer.parseInt(pages);

        if(value < 0)
            throw new ParserExceptions("Informe um valor válido!");

        if (max != -1 && value > max)
            throw new ParserExceptions("Informe um menor que o total de páginas.");

        return value;
    }

    public static void isbnValidator(String isbn) throws ParserExceptions {

        String isbnReplace = isbn.replaceAll("-", "");

        if(isbnReplace.length() != 13)
            throw new ParserExceptions("Informe um ISBN com tamanho válido!");

        if(!isbnReplace.matches("[0-9]+"))
            throw new ParserExceptions("Informe um ISBN com caracteres válidos!");
    }

    public static Book toBook(String name, String author, String isbn, String synopsis, String pages, Genre genre) throws ParserExceptions {
        int pagesInt = toInteger(pages, -1);

        isbnValidator(isbn);
        
        if(name.isEmpty() || author.isEmpty() || isbn.isEmpty() || synopsis.isEmpty() || pages.isEmpty())
            throw new ParserExceptions("Preencha todos os campos!");

        return new Book(name, author, isbn, synopsis, pagesInt, genre);
    }
}
