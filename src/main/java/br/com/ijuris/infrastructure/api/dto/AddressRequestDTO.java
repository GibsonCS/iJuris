package br.com.ijuris.infrastructure.api.dto;

public record AddressRequestDTO(String cep, String estado, String cidade, String bairro, String numero,
                                String complemento, String logradouro
) {
}
