package br.com.ijuris.domain.entity;

import br.com.ijuris.domain.vo.Cpf;
import br.com.ijuris.domain.vo.Email;
import br.com.ijuris.exception.BusinessException;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class User {

    private final UUID id;
    private final Cpf cpf;
    private final LocalDate dataNascimento;

    private final Email email;
    private final String nome;
    private final String sobrenome;

    private User(UUID id, String nome, String sobrenome, Cpf cpf, Email email, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public static User create(UUID id, String nome, String sobrenome, String cpf, String email,
                              LocalDate dataNascimento
    ) {
        validarNome(nome);
        validarNome(sobrenome);
        validateAge(dataNascimento);
        return new User(id, nome, sobrenome, new Cpf(cpf), new Email(email), dataNascimento);
    }

    private static void validarNome(String name) {
        if (name.isBlank()) {
            throw new BusinessException("Nome ou sobrenome não pode estar vazio!");
        }
    }

    private static void validateAge(LocalDate dataNascimento) {
        int age = Period.between(dataNascimento, LocalDate.now()).getYears();

        if (age < 18) {
            throw new BusinessException("Você deve ter 18 anos ou mais para usar nossos serviços.");
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

    public Email getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
