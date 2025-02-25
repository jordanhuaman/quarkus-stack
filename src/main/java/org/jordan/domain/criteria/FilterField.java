package org.jordan.domain.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterField {
    private final String value;

    public FilterField(final String value) {
        this.value = value;
    }
}
