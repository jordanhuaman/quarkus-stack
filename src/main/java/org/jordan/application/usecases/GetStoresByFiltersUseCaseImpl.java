package org.jordan.application.usecases;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jordan.application.in.GetStoresByFiltersUseCase;
import org.jordan.application.out.StoreRepositoryAdapterPort;
import org.jordan.domain.StoreEntity;
import org.jordan.domain.in.StoreFilter;

import java.util.List;

@ApplicationScoped
public class GetStoresByFiltersUseCaseImpl implements GetStoresByFiltersUseCase {
    @Inject
    StoreRepositoryAdapterPort storeRepositoryAdapterPort;
    @Override
    public Uni<List<StoreEntity>> getStoresByFilters(StoreFilter storeFilter) {
        return storeRepositoryAdapterPort.getStoresByFilters(storeFilter);
    }
}
