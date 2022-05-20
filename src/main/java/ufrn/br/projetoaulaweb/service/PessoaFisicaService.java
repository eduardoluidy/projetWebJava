package ufrn.br.projetoaulaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.Pessoa;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.repository.PessoaFisicaRepository;
import ufrn.br.projetoaulaweb.service.generic.AbstractService;

@Service
public class PessoaFisicaService extends AbstractService<PessoaFisica, PessoaFisicaRepository> {

    public PessoaFisicaService(PessoaFisicaRepository repository){
        super(repository);
    }

    //terá todos os métodos genéricos do abstract service.
    // Aqui irá somente os métodos particulares de PessoaFisicaService ex:
    //public User findUserByName(String name){}
    /*
    public PessoaFisica create(PessoaFisica p){
        return repository.save(p);
    } */
}
