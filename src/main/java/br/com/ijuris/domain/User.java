package br.com.ijuris.domain;

import br.com.ijuris.domain.vo.Cpf;
import br.com.ijuris.exception.BusinessException;

import java.time.LocalDate;
import java.util.UUID;

public class User {

    private final UUID id;
    private final Cpf cpf;
    private final LocalDate dataNascimento;

    private final String email;
    private final String nome;
    private final String sobrenome;

    private User(UUID id, String nome, String sobrenome, Cpf cpf, String email, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public static User create(UUID id, String nome, String sobrenome, String cpf, String email, LocalDate dataNascimento) {
        validarNome(nome);
        validarNome(sobrenome);
        return new User(id, nome, sobrenome, Cpf.create(cpf), email, dataNascimento);
    }

    private static void validarNome(String name) {
        if (name.isBlank()) {
            throw new BusinessException("Nome ou sobrenome não pode estar vazio!");
        }
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

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
