package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import ufrn.br.projetoaulaweb.dtos.PessoaFisicaDto;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.service.PessoaFisicaService;

import java.util.Optional;

@RestController
@RequestMapping("/pessoafisica")
public class PessoaFisicaController {
    protected final PessoaFisicaService pessoaFisicaService;
    public PessoaFisicaController(PessoaFisicaService service) {
        this.pessoaFisicaService = service;
    }

    @PostMapping
    public ResponseEntity<PessoaFisica> create(@RequestBody PessoaFisicaDto pessoaFisicaDto) {
        System.out.println(pessoaFisicaDto);
        var pessoaFisica = new PessoaFisica();
        BeanUtils.copyProperties(pessoaFisicaDto, pessoaFisica);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFisicaService.create(pessoaFisica));

    }

    @GetMapping
    public ResponseEntity<Page<PessoaFisica>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaFisicaService.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
        public ResponseEntity<PessoaFisica> findById(@PathVariable Long id){
        return pessoaFisicaService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PessoaFisicaDto pessoaFisicaDto) {

            Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaService.findById(id);
            if (!pessoaFisicaOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Fisica não encontrada.");
            }
            var pessoaFisica = new PessoaFisica();
            BeanUtils.copyProperties(pessoaFisicaDto, pessoaFisica);
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

