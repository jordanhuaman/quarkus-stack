package org.jordan.application.in;

import io.smallrye.mutiny.Uni;
import org.jordan.domain.dto.Store;

import java.util.List;

public interface GetAllStoresUseCase {
    Uni<List<Store>> getAllStores();
}
