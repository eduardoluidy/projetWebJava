package ufrn.br.projetoaulaweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.projetoaulaweb.controller.generic.AbstractController;
import ufrn.br.projetoaulaweb.model.PessoaJuridica;
import ufrn.br.projetoaulaweb.service.PessoaJuridicaService;

@RestController
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController extends AbstractController<PessoaJuridica, PessoaJuridicaService> {

    public PessoaJuridicaController(PessoaJuridicaService service) {
        super(service);
    }
}


