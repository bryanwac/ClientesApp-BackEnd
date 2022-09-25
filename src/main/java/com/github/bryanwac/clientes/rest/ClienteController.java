package com.github.bryanwac.clientes.rest;

import com.github.bryanwac.clientes.model.entity.Cliente;
import com.github.bryanwac.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController //Define um controlador com responsebody, tudo que é retornado é um corpo de resposta na requisição
@RequestMapping("/api/clientes") //Mapeia o URL base a ser tratado no controller
public class ClienteController {

    private final ClienteRepository repository;

    //Injeção por construtor
    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @PostMapping                         //Mapeando método para requisição Post
    @ResponseStatus(HttpStatus.CREATED)  //Pegando o Cód.de Status
    public Cliente salvar (@RequestBody Cliente cliente){
        return repository.save(cliente); //RequestBody avisando que esse objeto virá no corpo da req.
    }

                                                         // Define o parametro id como variavel
    @GetMapping("{id}")                                  // Mapeando para o Get HTTP
    public Cliente acharPorId(@PathVariable Integer id){ //Define o caminho da variavel e o tipo
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }                                                    // Retorna um Optional, caso encontre, armazena o cliente do ID,
                                                         // caso não, lança um erro de status404

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map(cliente ->{
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado ){
        repository
                .findById(id)
                .map( cliente -> {
                    cliente.setNome((clienteAtualizado.getNome()));
                    cliente.setCpf((clienteAtualizado).getCpf());
                    return repository.save(clienteAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
