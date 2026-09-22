package bancohorizonte.org.controller;


import bancohorizonte.org.controller.dto.ContaDtoRequest;
import bancohorizonte.org.controller.dto.ContaDtoResponse;
import bancohorizonte.org.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDtoResponse> buscarContaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ContaDtoResponse.de(contaService.buscarContaPorId(id)));
    }

    @PostMapping
    public ResponseEntity<ContaDtoResponse> salvarConta(@RequestBody ContaDtoRequest conta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ContaDtoResponse.de(contaService.salvarConta(conta)));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<ContaDtoResponse>> listarContasPorCliente(@PathVariable Long clienteId) {
        List<ContaDtoResponse> contas = ContaDtoResponse.de(contaService.listarContasPorCliente(clienteId));
        return ResponseEntity.status(HttpStatus.OK).body(contas);
    }

    @PatchMapping("/{id}/depositar")
    public ResponseEntity<ContaDtoResponse> depositar(@PathVariable Long id, @RequestBody Double valor) {
        return ResponseEntity.status(200).body(ContaDtoResponse.de(contaService.depositar(id, valor)));
    }

    @PatchMapping("/{id}/sacar")
    public ResponseEntity<ContaDtoResponse> sacar(@PathVariable Long id, @RequestBody Double valor) {
        return ResponseEntity.status(200).body(ContaDtoResponse.de(contaService.sacar(id, valor)));
    }

}
