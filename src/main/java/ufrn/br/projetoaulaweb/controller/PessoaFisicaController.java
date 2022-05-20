package ufrn.br.projetoaulaweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.projetoaulaweb.controller.generic.AbstractController;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoafisica")
public class PessoaFisicaController extends AbstractController<PessoaFisica, PessoaFisicaService> {

    public PessoaFisicaController(PessoaFisicaService service) {
        super(service);
    }
/*
    @Override
    @PostMapping
    public PessoaFisica create(@RequestBody PessoaFisica p) {
        PessoaFisica pf = service.create(p);
        System.out.println("test");
        return (pf);
    }  */
}

