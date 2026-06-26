package br.com.ijuris.core.domain.entity;

import br.com.ijuris.core.domain.vo.Cpf;
import br.com.ijuris.core.domain.vo.Email;
import br.com.ijuris.core.domain.vo.Password;
import br.com.ijuris.core.exception.BusinessException;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

    private final UUID id;
    private final Cpf cpf;

    private String name;
    private String lastname;
    private LocalDate dateOfBirthDay;
    private Email email;
    private Set<Role> roles = new HashSet<>();
    private Password password;

    private User(UUID id, String name, String lastname, Cpf cpf, Email email, LocalDate dateOfBirthDay, Password password) {
        this.password = password;

        validateName(name);
        validateName(lastname);
        validateAge(dateOfBirthDay);

        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.cpf = cpf;
        this.email = email;
        this.dateOfBirthDay = dateOfBirthDay;
        this.roles.add(Role.create("customer"));
    }

    public static User create(String nome, String lastName, String cpf, String email, LocalDate dataNascimento, String password) {
        return new User(UUID.randomUUID(), nome, lastName, new Cpf(cpf), new Email(email), dataNascimento, new Password(password));
    }

    public static User restore(UUID id, String name, String lastname, String cpf, String email, LocalDate dataNascimento, String password) {
        return new User(id, name, lastname, new Cpf(cpf), new Email(email), dataNascimento, new Password(password));
    }

    public void validatePassword(String password, String confirmPassword) {

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

    public void changeEmail(String email) {
        this.email = new Email(email);
    }

    public void addRole(Role r) {

        if (this.roles.contains(r)) {
            throw new BusinessException("Role já existe.");
        }

        this.roles.add(r);
    }

    public void changeName(String name) {
        if (name.isEmpty()) {
            throw new BusinessException("O nome não pode ser vazio");
        }
        if (name.length() <= 2) {
            throw new BusinessException("O nome deve ter mais de 2 caracteres.");
        }
        this.name = name;
    }

    public void changeDateOfBirthday(LocalDate dateOfBirthDay) {
        int age = Period.between(dateOfBirthDay, LocalDate.now()).getYears();

        if (age < 18) {
            throw new BusinessException("Você deve ter 18 anos ou mais para usar nossos serviços.");
        }

        this.dateOfBirthDay = dateOfBirthDay;
    }

    public void changeLastname(String lastname) {
        if (lastname.isEmpty()) {
            throw new BusinessException("O sobrenome não pode ser vazio");
        }
        if (lastname.length() <= 2) {
            throw new BusinessException("O nome sobrenome ter mais de 2 caracteres.");
        }
        this.lastname = lastname;
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

    public Password getPassword() {
        return password;
    }
}
