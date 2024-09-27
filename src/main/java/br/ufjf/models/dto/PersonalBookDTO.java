package br.ufjf.models.dto;

import br.ufjf.models.enums.Status;

public record PersonalBookDTO (String ISBN, String user, Status status, int currentPage) {}
