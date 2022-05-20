package ufrn.br.projetoaulaweb.service;

import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.Deficiencia;
import ufrn.br.projetoaulaweb.repository.DeficienciaRepository;
import ufrn.br.projetoaulaweb.service.generic.AbstractService;

@Service
public class DeficienciaService extends AbstractService<Deficiencia, DeficienciaRepository> {

    public DeficienciaService(DeficienciaRepository repository) {
        super(repository);
    }
}
