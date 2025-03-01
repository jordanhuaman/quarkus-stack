package org.jordan.domain.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private final OrderBy orderBy;
    private final OrderType orderType;
    public Order(final OrderBy orderBy,final OrderType orderType){
        this.orderBy = orderBy;
        this.orderType = orderType;
    }

    public static Order none(){
        return new Order(new OrderBy(""), new OrderType(OrderTypes.NONE));
    }
    public static Order fromPrimitives(String orderBy,OrderTypes orderTypes){
        return orderBy != null ? new Order(new OrderBy(orderBy),new OrderType(orderTypes)) : Order.none();
    }

}
