package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.projetoaulaweb.dtos.PessoaFisicaDtoResponse;
import ufrn.br.projetoaulaweb.dtos.PessoaJuridicaDtoRequest;
import ufrn.br.projetoaulaweb.dtos.PessoaJuridicaDtoResponse;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.model.PessoaJuridica;
import ufrn.br.projetoaulaweb.service.PessoaJuridicaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController {

    protected final PessoaJuridicaService pessoaJuridicaService;

    public PessoaJuridicaController(PessoaJuridicaService service) {
        this.pessoaJuridicaService = service;
    }

    @PostMapping
    public ResponseEntity<PessoaJuridica> create(@RequestBody PessoaJuridicaDtoRequest pessoaJuridicaDtoRequest) {
        System.out.println(pessoaJuridicaDtoRequest);
        var pessoaJuridica = new PessoaJuridica();
        BeanUtils.copyProperties(pessoaJuridicaDtoRequest, pessoaJuridica);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaJuridicaService.create(pessoaJuridica));

    }

    @GetMapping
    public ResponseEntity<List<PessoaJuridicaDtoResponse>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        //return ResponseEntity.status(HttpStatus.OK).body(pessoaJuridicaService.findAll(pageable));
        List<PessoaJuridicaDtoResponse> pessoaJuridicaDtoResponseList = new ArrayList<>();
        Page<PessoaJuridica> lista = pessoaJuridicaService.findAll(pageable);
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            for (PessoaJuridica pj : lista){
                PessoaJuridicaDtoResponse pessoaJuridicaDtoResponse = new PessoaJuridicaDtoResponse(pj);
                pessoaJuridicaDtoResponseList.add(pessoaJuridicaDtoResponse);
            }
            return ResponseEntity.ok().body(pessoaJuridicaDtoResponseList);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaJuridicaDtoResponse> findById(@PathVariable Long id){
        //public ResponseEntity<PessoaJuridicaDtoResponse> findById(@PathVariable Long id){
            Optional<PessoaJuridica> pessoaj = pessoaJuridicaService.findById(id);
            if(pessoaj.isEmpty()){
                return ResponseEntity.notFound().build();
            } else {
                PessoaJuridicaDtoResponse pessoaJuridicaDtoResponse = new PessoaJuridicaDtoResponse(pessoaj.get());
                return ResponseEntity.ok().body(pessoaJuridicaDtoResponse);
            }
        /* return pessoaJuridicaService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build()); */
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PessoaJuridicaDtoRequest pessoaJuridicaDtoRequest) {

        Optional<PessoaJuridica> pessoaJuridicaOptional = pessoaJuridicaService.findById(id);
        if (!pessoaJuridicaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Jurídica não encontrada.");
        }
        var pessoaJuridica = new PessoaJuridica();
        BeanUtils.copyProperties(pessoaJuridicaDtoRequest, pessoaJuridica);
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


