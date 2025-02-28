package org.jordan.domain.in;

import lombok.Data;
import org.jordan.domain.criteria.OrderTypes;

import java.util.ArrayList;
import java.util.List;

@Data
public class StoreFilter {
    private List<FilterIn> filterIns = new ArrayList<>();
    private String orderBy;
    private OrderTypes order;
}
