package org.jordan.domain.criteria;

import jakarta.persistence.criteria.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
    private final Filters filters;
    private final Order order;
    public Criteria(final Filters filters, final Order order) {
        this.filters =filters;
        this.order = order;
    }
}
