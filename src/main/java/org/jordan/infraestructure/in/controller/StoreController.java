package org.jordan.infraestructure.in.controller;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.hibernate.reactive.mutiny.Mutiny;
import org.jordan.application.in.GetAllStoresUseCase;
import org.jordan.application.in.GetStoresByFiltersUseCase;
import org.jordan.domain.BookEntity;
import org.jordan.domain.StoreEntity;
import org.jordan.domain.dto.Store;
import org.jordan.domain.in.StoreFilter;
import org.jordan.infraestructure.out.repository.BookRepository;
import org.jordan.infraestructure.out.repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@GraphQLApi
public class StoreController {
    @Inject
    GetAllStoresUseCase getAllStoresUseCase;
    @Inject
    StoreRepository storeRepository;
    @Inject
    BookRepository bookRepository;
    @Inject
    Mutiny.SessionFactory sessionFactory;
    @Inject
    GetStoresByFiltersUseCase getStoresByFiltersUseCase;
    @Query("TestStore")
    public Uni<String> testapplication(){
        return Uni.createFrom().item("Hello world");
    }

    @Query("GetStoresByFilters")
    public Uni<List<StoreEntity>> getStoresByFilters(StoreFilter storeFilter){
        return getStoresByFiltersUseCase.getStoresByFilters(storeFilter);
    }

    @Query("GetAllStores")
    public Uni<List<Store>> getAllStores() {
        Uni<BookEntity> bookEntityUni = sessionFactory
                .withSession(session -> bookRepository.findById(1L));

        Uni<BookEntity> bookEntityUni2 = sessionFactory
                .withSession(session -> bookRepository.findById(2L));
        Uni<StoreEntity> storeUni = sessionFactory
                .withSession(session -> storeRepository.findById(1L));

        return Uni.combine().all().unis(bookEntityUni, bookEntityUni2,storeUni)
                .with((book1, book2,book3) -> {
                    System.out.println("Book 1: " + book1);
                    System.out.println("Book 2: " + book2);
                    System.out.println("Another" + book3);
                    List<Store> stores = new ArrayList<>();
                    return stores;
                });
    }

    @Query("GetStoreById")
    @WithSession
    public Uni<StoreEntity> getStoreById(Long id){
        return storeRepository.findById(id);
    }
}
