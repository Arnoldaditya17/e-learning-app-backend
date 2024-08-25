package com.example.app.E_Learning_Application.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CustomPageResponse<T>{

    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean isLast;
    private List<T> content;
}
