package org.jordan.infraestructure.in.controller;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.jordan.domain.StoreEntity;
import org.jordan.infraestructure.in.params.StoreFilter;

import java.util.List;

@ApplicationScoped
@GraphQLApi
public class StoreController {
    @Query("TestStore")
    public Uni<String> testapplication(){
        return Uni.createFrom().item("Hello world");
    }

    @Query("GetStoresByFilters")
    public Uni<List<StoreEntity>> getStoresByFilters(StoreFilter storeFilter){
        return null;
    }
}
