package ufrn.br.projetoaulaweb.service;

import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.repository.EnderecoRepository;
import ufrn.br.projetoaulaweb.service.generic.AbstractService;
@Service
public class EnderecoService extends AbstractService<Endereco, EnderecoRepository> {

    public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}
