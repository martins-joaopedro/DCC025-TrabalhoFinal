package br.ufjf.models.dto;

import br.ufjf.models.enums.Status;

public record PersonalBookDTO (String ISBN, Status status, int currentPage) {}
