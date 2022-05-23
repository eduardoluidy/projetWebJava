package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.projetoaulaweb.dtos.DeficienciaDto;
import ufrn.br.projetoaulaweb.model.Deficiencia;
import ufrn.br.projetoaulaweb.service.DeficienciaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deficiencia")
public class DeficienciaController {

    protected final DeficienciaService deficienciaService;

    public DeficienciaController(DeficienciaService service) {
        this.deficienciaService = service;
    }

    @PostMapping
    public ResponseEntity<Deficiencia> create(@RequestBody DeficienciaDto deficienciaDto) {
        var deficiencia = new Deficiencia();
        BeanUtils.copyProperties(deficienciaDto, deficiencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(deficienciaService.create(deficiencia));
    }

    @GetMapping
    public ResponseEntity<List<Deficiencia>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(deficienciaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Deficiencia> findById(@PathVariable Long id){
        return deficienciaService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody DeficienciaDto deficienciaDto) {

        Optional<Deficiencia> deficienciaOptional = deficienciaService.findById(id);
        if (!deficienciaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrada.");
        }
        var deficiencia = new Deficiencia();
        BeanUtils.copyProperties(deficienciaDto, deficiencia);
        deficiencia.setId(deficienciaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(deficienciaService.create(deficiencia));
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (deficienciaService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
    }
}

