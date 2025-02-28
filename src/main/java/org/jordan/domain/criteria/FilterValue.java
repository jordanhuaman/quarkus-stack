package org.jordan.domain.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterValue {
    private String value;
    public FilterValue(final String value){
        this.value = value;
    }
}
