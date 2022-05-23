package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.projetoaulaweb.dtos.VinculoDto;
import ufrn.br.projetoaulaweb.model.Vinculo;
import ufrn.br.projetoaulaweb.service.VinculoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vinculo")
public class VinculoController {

    protected final VinculoService vinculoService;

    public VinculoController(VinculoService service) {
        this.vinculoService = service;
    }

    @PostMapping
    public ResponseEntity<Vinculo> create(@RequestBody VinculoDto vinculoDto) {
        var vinculo = new Vinculo();
        BeanUtils.copyProperties(vinculoDto, vinculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(vinculoService.create(vinculo));
    }

    @GetMapping
    public ResponseEntity<List<Vinculo>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(vinculoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vinculo> findById(@PathVariable Long id){
        return vinculoService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody VinculoDto vinculoDto) {

        Optional<Vinculo> vinculoOptional = vinculoService.findById(id);
        if (!vinculoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        var vinculo = new Vinculo();
        BeanUtils.copyProperties(vinculoDto, vinculo);
        vinculo.setId(vinculoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(vinculoService.create(vinculo));
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (vinculoService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
    }
}
