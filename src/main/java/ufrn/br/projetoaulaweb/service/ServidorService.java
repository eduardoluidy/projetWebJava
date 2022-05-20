package ufrn.br.projetoaulaweb.service;

import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.model.Servidor;
import ufrn.br.projetoaulaweb.repository.PessoaFisicaRepository;
import ufrn.br.projetoaulaweb.repository.ServidorRepository;
import ufrn.br.projetoaulaweb.service.generic.AbstractService;

@Service
public class ServidorService extends AbstractService<Servidor, ServidorRepository> {

    public ServidorService(ServidorRepository repository) {
        super(repository);
    }
}
