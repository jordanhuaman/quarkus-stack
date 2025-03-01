package org.jordan.domain.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderBy {
    private final String value;
    public OrderBy(final String value){
        this.value = value;
    }
}
