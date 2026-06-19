package br.com.ijuris.domain.entity;

import br.com.ijuris.domain.vo.Cpf;
import br.com.ijuris.domain.vo.Email;
import br.com.ijuris.exception.BusinessException;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

    private final UUID id;
    private final Cpf cpf;
    private final String nome;
    private final String sobrenome;
    private final LocalDate dataNascimento;

    private Email email;
    private Set<Role> roles = new HashSet<>();

    private User(UUID id, String nome, String sobrenome, Cpf cpf, Email email, LocalDate dataNascimento, Role role) {

        validarNome(nome);
        validarNome(sobrenome);
        validateAge(dataNascimento);
        addRole(role);

        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public static User create(String nome, String sobrenome, String cpf, String email,
                              LocalDate dataNascimento, Role role
    ) {

        return new User(UUID.randomUUID(), nome, sobrenome, new Cpf(cpf), new Email(email), dataNascimento, role);
    }

    private void validarNome(String name) {
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

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
