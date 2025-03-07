package org.jordan.domain.criteria;

import lombok.*;
import org.jordan.domain.in.StoreFilter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class Criteria {
    private final Filters filters;
    private final Order order;
    public Criteria(final Filters filters, final Order order) {
        this.filters =filters;
        this.order = order;
    }

    //TODO: delegate the logic to each class with 'fromPrimitives
    public static Criteria fromPrimitive(StoreFilter storeFilter){
        return new Criteria(
                Filters.fromPrimitives(storeFilter.getFilterIns()),
                Order.fromPrimitives(storeFilter.getOrderBy(), storeFilter.getOrder())
        );
    }
    public static Criteria deserializeCriteria(StoreFilter storeFilter){
        return new Criteria(
                Criteria.obtainFiltersToCriteria(storeFilter.getFilterIns()),
                Criteria.obtainOrderToCriteria(storeFilter.getOrderBy(), storeFilter.getOrder()));
    }

    public static Filters obtainFiltersToCriteria(List<FilterRecord> filters){
        if (filters==null || filters.size()==0){
            return new Filters(new ArrayList<>());
        }

        List<Filter> filterList = filters.stream().map(filterIn -> {
            FilterField filterField = new FilterField(filterIn.field());
            FilterOperator filterOperator = new FilterOperator(filterIn.operator());
            FilterValue filterValue = new FilterValue(filterField.getValue());
            return new Filter(filterField,filterOperator,filterValue);
        }).toList();
        return new Filters(filterList);
    }

    public static Order obtainOrderToCriteria(String orderBy, OrderTypes order){
        OrderBy orderBy1 = new OrderBy(orderBy);
        OrderType orderType = new OrderType(order);
        return new Order(orderBy1,orderType);
    }

}
