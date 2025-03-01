package org.jordan.domain.in;

import lombok.Data;
import org.jordan.domain.criteria.FilterRecord;
import org.jordan.domain.criteria.OrderTypes;

import java.util.ArrayList;
import java.util.List;

@Data
public class StoreFilter {
    private List<FilterRecord> filterIns = new ArrayList<>();
    private String orderBy;
    private OrderTypes order;
}
