package org.jordan.application.in;

import io.smallrye.mutiny.Uni;
import org.jordan.domain.StoreEntity;
import org.jordan.domain.in.StoreFilter;

import java.util.List;

public interface GetStoresByFiltersUseCase {
    Uni<List<StoreEntity>> getStoresByFilters(StoreFilter storeFilter);
}
