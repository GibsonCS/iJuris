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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "date_of_birthday", nullable = false)
    private LocalDate dateOfBirthDay;

    @ManyToMany
    private Set<RoleDbEntity> roles = new HashSet<>();

    public UserDbEntity() {
    }

    public UserDbEntity(String name, String lastName, String cpf, String email, LocalDate dateOfBirthDay,
                        String password, Set<RoleDbEntity> roles
    ) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.dateOfBirthDay = dateOfBirthDay;
        this.password = password;
        this.roles = roles;
    }
}
