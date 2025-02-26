package org.jordan.infraestructure.out.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.jordan.domain.StoreEntity;

@ApplicationScoped
public class StoreRepository implements PanacheRepositoryBase<StoreEntity, Long> {
}
