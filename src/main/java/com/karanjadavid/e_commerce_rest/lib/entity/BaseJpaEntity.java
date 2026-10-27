package com.karanjadavid.e_commerce_rest.lib.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseJpaEntity {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false)
    private String entityId;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(updatable = false)
    private String createdByEntityId;

    private LocalDateTime updatedAt;

    private String updatedByEntityId;

    private LocalDateTime deletedAt;

    private String deletedByEntityId;

    public BaseJpaEntity() {
        generateEntityId();
    }

    private void generateEntityId() {
        if (getEntityId() == null) {
            ObjectId objectId = ObjectId.get();
            String entityId = String.format(
                    "%s-%s",
                    getClass().getSimpleName().toLowerCase(),
                    objectId
            );

            setEntityId(entityId);
        }
    }

    public boolean getIsDeleted() {
        return getDeletedAt() != null || getDeletedByEntityId() != null;
    }
}
