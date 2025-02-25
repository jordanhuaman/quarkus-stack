package org.jordan.domain.criteria;

public class Order {
    public Order(final OrderBy orderBy,final OrderType orderType){}

    public static Order none(){
        return new Order(new OrderBy(""), new OrderType(OrderTypes.NONE));
    }
}
