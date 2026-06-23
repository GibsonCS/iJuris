package br.com.ijuris.core.domain.entity;

import br.com.ijuris.core.domain.vo.Cpf;
import br.com.ijuris.core.domain.vo.Email;
import br.com.ijuris.core.exception.BusinessException;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

    private final UUID id;
    private final Cpf cpf;
    private final String name;
    private final String lastname;
    private final LocalDate dateOfBirthDay;

    private Email email;
    private Set<Role> roles = new HashSet<>();
    private String password;

    private User(UUID id, String name, String lastname, Cpf cpf, Email email, LocalDate dateOfBirthDay, Role role, String password) {
        this.password = password;

        validateName(name);
        validateName(lastname);
        validateAge(dateOfBirthDay);
        addRole(role);

        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.cpf = cpf;
        this.email = email;
        this.dateOfBirthDay = dateOfBirthDay;
    }

    public static User create(String nome, String lastName, String cpf, String email, LocalDate dataNascimento, Role role, String password) {
        return new User(UUID.randomUUID(), nome, lastName, new Cpf(cpf), new Email(email), dataNascimento, role, password);
    }

    public void validatePassword(String password, String confirmPassword){

    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new BusinessException("Nome ou sobrenome não pode estar vazio!");
        }
    }

    private void validateAge(LocalDate dataNascimento) {
        int age = Period.between(dataNascimento, LocalDate.now()).getYears();

        if (age < 18) {
            throw new BusinessException("Você deve ter 18 anos ou mais para usar nossos serviços.");
        }
    }

    private void addRole(Role r) {

        if (this.roles.contains(r)) {
            throw new BusinessException("Role já existe.");
        }

        this.roles.add(r);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public LocalDate getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getPassword() {return  password;}
}
