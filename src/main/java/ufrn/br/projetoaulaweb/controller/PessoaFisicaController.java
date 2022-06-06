package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import ufrn.br.projetoaulaweb.dtos.PessoaFisicaDtoRequest;
import ufrn.br.projetoaulaweb.dtos.PessoaFisicaDtoResponse;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.service.PessoaFisicaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoafisica")
public class PessoaFisicaController {
    protected final PessoaFisicaService pessoaFisicaService;
    public PessoaFisicaController(PessoaFisicaService service) {
        this.pessoaFisicaService = service;
    }

    @PostMapping
    public ResponseEntity<PessoaFisica> create(@RequestBody PessoaFisicaDtoRequest pessoaFisicaDtoRequest) {
        var pessoaFisica = new PessoaFisica();
        BeanUtils.copyProperties(pessoaFisicaDtoRequest, pessoaFisica);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFisicaService.create(pessoaFisica));

    }

    @GetMapping
    public ResponseEntity<List<PessoaFisicaDtoResponse>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        List<PessoaFisicaDtoResponse> pessoaFisicaDtoResponseList = new ArrayList<>();
        Page<PessoaFisica> lista = pessoaFisicaService.findAll(pageable);
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            for (PessoaFisica pf : lista){
                PessoaFisicaDtoResponse pessoaFisicaDtoResponse = new PessoaFisicaDtoResponse(pf);
                pessoaFisicaDtoResponseList.add(pessoaFisicaDtoResponse);
            }
            return ResponseEntity.ok().body(pessoaFisicaDtoResponseList);
        }
    }

    @GetMapping(value = "/{id}")
        public ResponseEntity<PessoaFisicaDtoResponse> findById(@PathVariable Long id){
        Optional<PessoaFisica> pessoaf = pessoaFisicaService.findById(id);
        if(pessoaf.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            PessoaFisicaDtoResponse pessoaFisicaDtoResponse = new PessoaFisicaDtoResponse(pessoaf.get());
            return ResponseEntity.ok().body(pessoaFisicaDtoResponse);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PessoaFisicaDtoRequest pessoaFisicaDtoRequest) {

            Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaService.findById(id);
            if (!pessoaFisicaOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Fisica não encontrada.");
            }
            var pessoaFisica = new PessoaFisica();
            BeanUtils.copyProperties(pessoaFisicaDtoRequest, pessoaFisica);
            pessoaFisica.setId(pessoaFisicaOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(pessoaFisicaService.create(pessoaFisica));
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (pessoaFisicaService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
    }

}

