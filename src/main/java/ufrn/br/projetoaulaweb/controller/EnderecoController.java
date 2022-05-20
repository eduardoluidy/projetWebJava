package ufrn.br.projetoaulaweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.projetoaulaweb.controller.generic.AbstractController;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends AbstractController<Endereco, EnderecoService> {

    public EnderecoController(EnderecoService service) {
        super(service);
    }
}