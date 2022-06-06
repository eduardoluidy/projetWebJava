package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.projetoaulaweb.dtos.EnderecoDtoRequest;
import ufrn.br.projetoaulaweb.dtos.EnderecoDtoResponse;
import ufrn.br.projetoaulaweb.dtos.PessoaFisicaDtoResponse;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.service.EnderecoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    protected final EnderecoService enderecoService;

    public EnderecoController(EnderecoService service) {
        this.enderecoService = service;
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody EnderecoDtoRequest enderecoDtoRequest) {
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDtoRequest, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.create(endereco));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDtoResponse>> getAll(){
        //return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
        List<EnderecoDtoResponse> enderecoDtoResponseList = new ArrayList<>();
        List<Endereco> lista = enderecoService.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            for (Endereco endereco : lista){
                EnderecoDtoResponse enderecoDtoResponse = new EnderecoDtoResponse(endereco);
                enderecoDtoResponseList.add(enderecoDtoResponse);
            }
            return ResponseEntity.ok().body(enderecoDtoResponseList);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDtoResponse> findById(@PathVariable Long id){
        Optional<Endereco> endereco = enderecoService.findById(id);
        if(endereco.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            EnderecoDtoResponse enderecoDtoResponse = new EnderecoDtoResponse(endereco.get());
            return ResponseEntity.ok().body(enderecoDtoResponse);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody EnderecoDtoRequest enderecoDtoRequest) {

        Optional<Endereco> enderecoOptional = enderecoService.findById(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrada.");
        }
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDtoRequest, endereco);
        endereco.setId(enderecoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.create(endereco));
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (enderecoService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
    }
}