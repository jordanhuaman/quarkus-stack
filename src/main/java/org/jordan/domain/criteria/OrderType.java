package org.jordan.domain.criteria;

import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderType {
    private final OrderTypes orderTypes;
    public OrderType(final OrderTypes orderTypes){
        this.orderTypes = orderTypes;
    }
}
