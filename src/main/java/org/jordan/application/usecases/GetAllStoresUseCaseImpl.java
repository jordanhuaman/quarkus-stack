package org.jordan.application.usecases;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jordan.application.in.GetAllStoresUseCase;
import org.jordan.application.out.StoreRepositoryAdapterPort;
import org.jordan.domain.dto.Store;

import java.util.List;

@ApplicationScoped
public class GetAllStoresUseCaseImpl implements GetAllStoresUseCase {
    @Inject
    StoreRepositoryAdapterPort storeRepositoryAdapterPort;
    @Override
    public Uni<List<Store>> getAllStores() {
        return storeRepositoryAdapterPort.getAllStores();
    }
}
