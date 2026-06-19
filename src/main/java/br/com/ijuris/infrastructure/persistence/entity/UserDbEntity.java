package br.com.ijuris.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserDbEntity {

    @Id
    private UUID id;
    private String name;
    private String lastName;
    private String cpf;
    private String email;

    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthDay;

    @ManyToMany
    private Set<RoleDbEntity> roles = new HashSet<>();
}
