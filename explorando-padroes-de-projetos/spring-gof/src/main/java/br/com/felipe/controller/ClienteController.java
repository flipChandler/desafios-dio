package br.com.felipe.controller;

import br.com.felipe.model.Cliente;
import br.com.felipe.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * interface do swagger: localhost:8080/swagger-ui.html
 */
@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public void inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}
