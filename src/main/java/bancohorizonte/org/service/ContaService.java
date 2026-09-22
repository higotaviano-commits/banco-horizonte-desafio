package bancohorizonte.org.service;

import bancohorizonte.org.controller.dto.ContaDtoRequest;
import bancohorizonte.org.entity.Conta;
import bancohorizonte.org.entity.TipoConta;
import bancohorizonte.org.exception.ContaNaoEncontradaException;
import bancohorizonte.org.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }


    public Conta buscarContaPorId(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new ContaNaoEncontradaException(id));
    }

    public Conta salvarConta(ContaDtoRequest conta) {
        Conta novaConta = new Conta();
        novaConta.setAgencia(0001L);
        novaConta.setNumero(Conta.gerarNumeroConta());
        novaConta.setTipo(TipoConta.valueOf(conta.tipoConta()));
        return contaRepository.save(novaConta);
    }

    public List<Conta> listarContasPorCliente(Long clienteId) {
        return contaRepository.findAllByClienteId(clienteId);
    }

    public Conta depositar(Long id, Double valor) {
        Conta conta = buscarContaPorId(id);
        conta.depositar(valor);
        return contaRepository.save(conta);
    }

    public Conta sacar(Long id, Double valor) {
        Conta conta = buscarContaPorId(id);
        conta.sacar(valor);
        return contaRepository.save(conta);
    }


}
