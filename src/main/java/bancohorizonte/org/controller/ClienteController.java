package bancohorizonte.org.controller;

import bancohorizonte.org.controller.dto.ClienteDtoRequest;
import bancohorizonte.org.controller.dto.ClienteDtoResponse;
import bancohorizonte.org.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping
    public ResponseEntity<ClienteDtoResponse> salvarCliente(@RequestBody ClienteDtoRequest cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteDtoResponse.de(clienteService.salvarCliente(cliente)));
    }

}
