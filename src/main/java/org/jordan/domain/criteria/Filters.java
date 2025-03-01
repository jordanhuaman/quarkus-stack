package org.jordan.domain.criteria;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Filters {
    private List<Filter> filters;
    public Filters(final List<Filter> filters){
        this.filters = filters;
    }
    public static Filters fromPrimitives(List<FilterRecord> filters){
        if (filters == null){
            return new Filters(new ArrayList<>());
        }
        return new Filters(
                filters
                        .stream()
                        .map(filter ->
                                Filter.fromPrimitives(
                                        filter.field(),
                                        filter.operator()
                                        ,filter.value()))
                        .toList());
    }
}
