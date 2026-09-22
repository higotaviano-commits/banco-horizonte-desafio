package bancohorizonte.org.controller.dto;

import bancohorizonte.org.entity.Cliente;

import java.util.List;

public record ClienteDtoResponse(Long id, String nome, String email, String cpf) {

    public static ClienteDtoResponse de(Cliente cliente) {
        return new ClienteDtoResponse(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf());
    }

    public static List<ClienteDtoResponse> de(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteDtoResponse::de)
                .toList();
    }
}
