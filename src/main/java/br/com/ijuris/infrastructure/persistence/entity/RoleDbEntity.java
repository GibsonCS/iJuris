package br.com.ijuris.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "roles")
@Data
public class RoleDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    public RoleDbEntity() {}

    public RoleDbEntity(String name) {
        this.name = name;
    }
}
