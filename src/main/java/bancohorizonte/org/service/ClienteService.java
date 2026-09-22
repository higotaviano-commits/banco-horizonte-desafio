package bancohorizonte.org.service;

import bancohorizonte.org.controller.dto.ClienteDtoRequest;
import bancohorizonte.org.entity.Cliente;
import bancohorizonte.org.exception.ClienteNaoEncontradoException;
import bancohorizonte.org.exception.CpfJaCadastradoException;
import bancohorizonte.org.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }

    public Cliente salvarCliente(ClienteDtoRequest cliente) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(cliente.nome());
        novoCliente.setEmail(cliente.email());
        novoCliente.setCpf(cliente.cpf());
        return clienteRepository.save(novoCliente);
    }

    private boolean validaCpf(String cpf) {
        return !clienteRepository.existsByCpf(cpf);
    }


}
