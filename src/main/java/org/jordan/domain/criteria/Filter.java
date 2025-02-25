package org.jordan.domain.criteria;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Filter {
    private final FilterField filterField;
    private final FilterOperator filterOperator;
    private final FilterValue filterValue;
    public Filter(final FilterField filterField,final FilterOperator filterOperator,final FilterValue filterValue){
        this.filterField = filterField;
        this.filterOperator = filterOperator;
        this.filterValue = filterValue;
    }
}
