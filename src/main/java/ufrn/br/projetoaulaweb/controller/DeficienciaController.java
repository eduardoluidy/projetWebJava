package ufrn.br.projetoaulaweb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.projetoaulaweb.dtos.DeficienciaDtoRequest;
import ufrn.br.projetoaulaweb.dtos.DeficienciaDtoResponse;
import ufrn.br.projetoaulaweb.dtos.EnderecoDtoResponse;
import ufrn.br.projetoaulaweb.model.Deficiencia;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.service.DeficienciaService;

import java.util.ArrayList;
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
    public ResponseEntity<Deficiencia> create(@RequestBody DeficienciaDtoRequest deficienciaDtoRequest) {
        var deficiencia = new Deficiencia();
        BeanUtils.copyProperties(deficienciaDtoRequest, deficiencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(deficienciaService.create(deficiencia));
    }

    @GetMapping
    public ResponseEntity<List<DeficienciaDtoResponse>> getAll(){
        List<DeficienciaDtoResponse> deficienciaDtoResponseList = new ArrayList<>();
        List<Deficiencia> lista = deficienciaService.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            for (Deficiencia deficiencia : lista){
                DeficienciaDtoResponse deficienciaDtoResponse = new DeficienciaDtoResponse(deficiencia);
                deficienciaDtoResponseList.add(deficienciaDtoResponse);
            }
            return ResponseEntity.ok().body(deficienciaDtoResponseList);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DeficienciaDtoResponse> findById(@PathVariable Long id){
        Optional<Deficiencia> deficiencia = deficienciaService.findById(id);
        if(deficiencia.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            DeficienciaDtoResponse deficienciaDtoResponse = new DeficienciaDtoResponse(deficiencia.get());
            return ResponseEntity.ok().body(deficienciaDtoResponse);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody DeficienciaDtoRequest deficienciaDtoRequest) {

        Optional<Deficiencia> deficienciaOptional = deficienciaService.findById(id);
        if (!deficienciaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrada.");
        }
        var deficiencia = new Deficiencia();
        BeanUtils.copyProperties(deficienciaDtoRequest, deficiencia);
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

