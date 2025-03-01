package org.jordan.application.out;

import io.smallrye.mutiny.Uni;
import org.jordan.domain.StoreEntity;
import org.jordan.domain.dto.Store;
import org.jordan.domain.in.StoreFilter;

import java.util.List;

public interface StoreRepositoryAdapterPort {
    Uni<List<Store>> getAllStores();
    Uni<List<StoreEntity>> getStoresByFilters(StoreFilter storeFilter);
}
