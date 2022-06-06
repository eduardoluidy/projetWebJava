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
import ufrn.br.projetoaulaweb.dtos.ServidorDtoRequest;
import ufrn.br.projetoaulaweb.dtos.ServidorDtoResponse;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.model.Servidor;
import ufrn.br.projetoaulaweb.service.ServidorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servidor")
public class ServidorController {
    protected final ServidorService servidorService;

    public ServidorController(ServidorService service) {

        this.servidorService = service;
    }

    @PostMapping
    public ResponseEntity<Servidor> create(@RequestBody ServidorDtoRequest servidorDtoRequest) {
        var servidor = new Servidor();
        BeanUtils.copyProperties(servidorDtoRequest, servidor);
        return ResponseEntity.status(HttpStatus.CREATED).body(servidorService.create(servidor));
    }

    @GetMapping
    public ResponseEntity<List<ServidorDtoResponse>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        //return ResponseEntity.status(HttpStatus.OK).body(servidorService.findAll(pageable));
        List<ServidorDtoResponse> servidorDtoResponseList = new ArrayList<>();
        Page<Servidor> lista = servidorService.findAll(pageable);
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            for (Servidor servidor : lista){
                ServidorDtoResponse servidorDtoResponse = new ServidorDtoResponse(servidor);
                servidorDtoResponseList.add(servidorDtoResponse);
            }
            return ResponseEntity.ok().body(servidorDtoResponseList);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServidorDtoResponse> findById(@PathVariable Long id){
        Optional<Servidor> servidor = servidorService.findById(id);
        if(servidor.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            ServidorDtoResponse servidorDtoResponse = new ServidorDtoResponse(servidor.get());
            return ResponseEntity.ok().body(servidorDtoResponse);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ServidorDtoRequest servidorDtoRequest) {

        Optional<Servidor> servidorOptional = servidorService.findById(id);
        if (!servidorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Servidor não encontrada.");
        }
        var servidor = new Servidor();
        BeanUtils.copyProperties(servidorOptional, servidor);
        servidor.setId(servidorOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(servidorService.create(servidor));
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (servidorService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Servidor não encontrado.");
        }
    }

}
