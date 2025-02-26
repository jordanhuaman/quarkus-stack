package org.jordan.infraestructure.in.controller;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithSessionOnDemand;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.With;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.hibernate.reactive.mutiny.Mutiny;
import org.jordan.application.in.GetAllStoresUseCase;
import org.jordan.domain.BookEntity;
import org.jordan.domain.StoreEntity;
import org.jordan.domain.dto.Store;
import org.jordan.infraestructure.in.params.StoreFilter;
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
    @Query("TestStore")
    public Uni<String> testapplication(){
        return Uni.createFrom().item("Hello world");
    }

    @Query("GetStoresByFilters")
    public Uni<List<StoreEntity>> getStoresByFilters(StoreFilter storeFilter){
        return Uni.createFrom().item(null);
    }

    @Query("GetAllStores")
    public Uni<List<Store>> getAllStores() {
        Uni<BookEntity> bookEntityUni = sessionFactory
                .withSession(session -> bookRepository.findById(1L));

        Uni<BookEntity> bookEntityUni2 = sessionFactory
                .withSession(session -> bookRepository.findById(2L));

        return Uni.combine().all().unis(bookEntityUni, bookEntityUni2)
                .with((book1, book2) -> {
                    System.out.println("Book 1: " + book1);
                    System.out.println("Book 2: " + book2);

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
