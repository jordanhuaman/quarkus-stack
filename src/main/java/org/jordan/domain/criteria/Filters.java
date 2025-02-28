package org.jordan.domain.criteria;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Filters {
    private List<Filter> filters;
    public Filters(final List<Filter> filters){
        this.filters = filters;
    }
}
