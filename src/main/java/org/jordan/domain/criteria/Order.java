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
}
