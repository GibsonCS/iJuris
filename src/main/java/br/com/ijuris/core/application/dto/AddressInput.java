package br.com.ijuris.core.application.dto;

public record AddressInput(String cep, String estado, String cidade, String bairro,
                           String numero, String complemento, String logradouro) {
}
