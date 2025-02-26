package org.jordan.infraestructure.out.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.jordan.domain.BookEntity;

@ApplicationScoped
public class BookRepository implements PanacheRepositoryBase<BookEntity, Long> {
}
