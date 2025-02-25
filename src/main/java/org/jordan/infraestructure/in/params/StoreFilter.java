package org.jordan.infraestructure.in.params;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StoreFilter {
    private List<Filter> filters = new ArrayList<>();
    private String orderBy;
    private String order;
}
