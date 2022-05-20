package ufrn.br.projetoaulaweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.projetoaulaweb.controller.generic.AbstractController;
import ufrn.br.projetoaulaweb.model.Deficiencia;
import ufrn.br.projetoaulaweb.service.DeficienciaService;

@RestController
@RequestMapping("/deficiencia")
public class DeficienciaController extends AbstractController<Deficiencia, DeficienciaService> {

    public DeficienciaController(DeficienciaService service) {
        super(service);
    }
}
