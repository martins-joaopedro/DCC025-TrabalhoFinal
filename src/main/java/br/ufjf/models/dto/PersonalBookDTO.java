package br.ufjf.models.dto;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import br.ufjf.models.enums.Status;

public record PersonalBookDTO (String ISBN, String user, Status status, int currentPage) {}
