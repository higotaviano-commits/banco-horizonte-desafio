package bancohorizonte.org.controller.dto;

import bancohorizonte.org.entity.Cliente;
import bancohorizonte.org.entity.Conta;
import bancohorizonte.org.entity.TipoConta;

import java.util.List;

public record ContaDtoResponse(Long id, Long numero, Long agencia, TipoConta tipoConta, Cliente cliente) {


    public static ContaDtoResponse de(Conta conta) {
        return new ContaDtoResponse(conta.getId(), conta.getNumero(), conta.getAgencia(), conta.getTipo(), conta.getCliente());
    }

    public static List<ContaDtoResponse> de(List<Conta> contas) {
        return contas.stream()
                .map(ContaDtoResponse::de)
                .toList();
    }
}
