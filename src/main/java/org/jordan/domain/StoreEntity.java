package org.jordan.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Store", schema = "store")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
