package org.jordan.application.out;

import io.smallrye.mutiny.Uni;
import org.jordan.domain.dto.Store;

import java.util.List;

public interface StoreRepositoryAdapterPort {
    Uni<List<Store>> getAllStores();
}
