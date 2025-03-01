package org.jordan.domain.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterOperator {
    private final Operator operator;
    public FilterOperator(final Operator value){
        this.operator = value;
    }
}
