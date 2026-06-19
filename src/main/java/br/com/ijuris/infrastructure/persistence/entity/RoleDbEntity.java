package br.com.ijuris.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "roles")
public class RoleDbEntity {

    @Id
    private UUID id;

    private String name;
}
