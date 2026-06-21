package br.com.ijuris.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
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

    public UserDbEntity(){}

    public UserDbEntity(String name, String lastName, String cpf, String email, LocalDate dateOfBirthDay, Set<RoleDbEntity> roles) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.dateOfBirthDay = dateOfBirthDay;
        this.roles = roles;
    }
}
