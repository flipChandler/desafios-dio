package br.com.felipe.service.impl;

import br.com.felipe.model.Cliente;
import br.com.felipe.model.Endereco;
import br.com.felipe.repository.ClienteRepository;
import br.com.felipe.repository.EnderecoRepository;
import br.com.felipe.service.ClienteService;
import br.com.felipe.service.ViaCepService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              EnderecoRepository enderecoRepository,
                              ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }

    @Transactional
    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Transactional
    @Override
    public void atualizar(Long id, Cliente cliente) {
        clienteRepository.findById(id)
                .ifPresent(clienteSalvo -> {
                    cliente.setId(id);
                    salvarClienteComCep(cliente);
                });
    }

    @Transactional
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep)
                .orElseGet(() -> {
                   Endereco novoEndereco = viaCepService.consultarCep(cep);
                   return enderecoRepository.save(novoEndereco);
                });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
