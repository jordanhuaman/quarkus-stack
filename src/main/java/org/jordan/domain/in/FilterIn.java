package org.jordan.domain.in;

import lombok.Data;
import org.jordan.domain.criteria.Operator;

@Data
public class FilterIn {
    private String name;
    private Operator operator;
    private String value;

}
