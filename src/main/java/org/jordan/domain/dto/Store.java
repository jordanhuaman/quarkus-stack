package org.jordan.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Store {
    private Long id;
    private String name;
    private List<Book> books = new ArrayList<>();
}
