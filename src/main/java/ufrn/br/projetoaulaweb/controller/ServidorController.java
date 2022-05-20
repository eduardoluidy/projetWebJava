package ufrn.br.projetoaulaweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.projetoaulaweb.controller.generic.AbstractController;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.model.Servidor;
import ufrn.br.projetoaulaweb.service.PessoaFisicaService;
import ufrn.br.projetoaulaweb.service.ServidorService;

@RestController
@RequestMapping("/servidor")
public class ServidorController extends AbstractController<Servidor, ServidorService> {
    public ServidorController(ServidorService service) {
        super(service);
    }
}
