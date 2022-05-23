package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.projetoaulaweb.dtos.PessoaJuridicaDto;
import ufrn.br.projetoaulaweb.model.PessoaJuridica;
import ufrn.br.projetoaulaweb.service.PessoaJuridicaService;

import java.util.Optional;

@RestController
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController {

    protected final PessoaJuridicaService pessoaJuridicaService;

    public PessoaJuridicaController(PessoaJuridicaService service) {
        this.pessoaJuridicaService = service;
    }

    @PostMapping
    public ResponseEntity<PessoaJuridica> create(@RequestBody PessoaJuridicaDto pessoaJuridicaDto) {
        System.out.println(pessoaJuridicaDto);
        var pessoaJuridica = new PessoaJuridica();
        BeanUtils.copyProperties(pessoaJuridicaDto, pessoaJuridica);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaJuridicaService.create(pessoaJuridica));

    }

    @GetMapping
    public ResponseEntity<Page<PessoaJuridica>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaJuridicaService.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaJuridica> findById(@PathVariable Long id){
        return pessoaJuridicaService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PessoaJuridicaDto pessoaJuridicaDto) {

        Optional<PessoaJuridica> pessoaJuridicaOptional = pessoaJuridicaService.findById(id);
        if (!pessoaJuridicaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Jurídica não encontrada.");
        }
        var pessoaJuridica = new PessoaJuridica();
        BeanUtils.copyProperties(pessoaJuridicaDto, pessoaJuridica);
        pessoaJuridica.setId(pessoaJuridicaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaJuridicaService.create(pessoaJuridica));
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (pessoaJuridicaService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
    }

}


