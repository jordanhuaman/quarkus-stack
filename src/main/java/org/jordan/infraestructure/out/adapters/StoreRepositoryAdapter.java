package org.jordan.infraestructure.out.adapters;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jordan.application.out.StoreRepositoryAdapterPort;
import org.jordan.domain.BookEntity;
import org.jordan.domain.StoreEntity;
import org.jordan.domain.criteria.*;
import org.jordan.domain.dto.Store;
import org.jordan.domain.in.StoreFilter;
import org.jordan.infraestructure.out.repository.BookRepository;
import org.jordan.infraestructure.out.repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class StoreRepositoryAdapter implements StoreRepositoryAdapterPort {
    @Inject
    StoreRepository storeRepository;
    @Inject
    BookRepository bookRepository;
    @Override
    public Uni<List<Store>> getAllStores() {
        Uni<BookEntity> bookEntityUni = bookRepository.findById((long)1)
                .onItem()
                .ifNull()
                .failWith(new IllegalArgumentException("Not found"))
                .onItem()
                .ifNotNull()
                .transformToUni(bookEntity -> Uni.createFrom().item(bookEntity))
                .onFailure().invoke(failure ->{
                    System.out.println(failure.getMessage());
                })
                .onFailure().recoverWithNull();
        Uni<BookEntity> bookEntityUni2 = bookRepository.findById((long)2)
                .onItem()
                .ifNull()
                .failWith(new IllegalArgumentException("Not found"))
                .onItem()
                .ifNotNull()
                .transformToUni(bookEntity -> Uni.createFrom().item(bookEntity))
                .onFailure().invoke(failure ->{
                    System.out.println(failure.getMessage());
                })
                .onFailure().recoverWithNull();
        return Uni.join().all(bookEntityUni,bookEntityUni2)
                .andCollectFailures()
                .map(bookEntities -> {
                    System.out.println(bookEntities.get(0));
                    List<Store> stores = new ArrayList<>();
                    return stores;
                });
    }

    @Override
    public Uni<List<StoreEntity>> getStoresByFilters(StoreFilter storeFilter) {
        // Criteria criteria = Criteria.deserializeCriteria(storeFilter);
        //TODO: same way
        Criteria criteria = Criteria.fromPrimitive(storeFilter);
        System.out.println(criteria.getOrder().getOrderBy().getValue());
        return Uni.createFrom().item(new ArrayList<>());
    }
}
