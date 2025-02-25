package org.jordan.infraestructure.in.params;

import lombok.Data;

@Data
public class Filter {
    private String name;
    private String operator;
    private String value;

}
