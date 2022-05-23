package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.projetoaulaweb.dtos.DeficienciaDto;
import ufrn.br.projetoaulaweb.dtos.EnderecoDto;
import ufrn.br.projetoaulaweb.model.Deficiencia;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.service.EnderecoService;

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
    public ResponseEntity<Endereco> create(@RequestBody EnderecoDto enderecoDto) {
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDto, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.create(endereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id){
        return enderecoService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody EnderecoDto enderecoDto) {

        Optional<Endereco> enderecoOptional = enderecoService.findById(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrada.");
        }
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDto, endereco);
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