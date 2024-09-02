package com.projecto.project.Embeddable;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CreatedUpdatedTime {

    /* Esta clase es un embebible de la fecha-hora de creación y actualización de un registro en cualquier entidad
    que llegase a tener estos dos campos.*/

    @Column(nullable = true, updatable = false)
    @CreationTimestamp 
    private LocalDateTime createdAt;

    @Column(nullable = true, updatable = false)
    @CreationTimestamp
    private LocalDateTime updatedAt;

     @PrePersist
    public void prePersistAudit() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdateAudit() {
        updatedAt = LocalDateTime.now();
    }

}
