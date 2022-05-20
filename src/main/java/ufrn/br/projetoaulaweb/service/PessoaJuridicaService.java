package ufrn.br.projetoaulaweb.service;

import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.model.PessoaJuridica;
import ufrn.br.projetoaulaweb.repository.PessoaFisicaRepository;
import ufrn.br.projetoaulaweb.repository.PessoaJuridicaRepository;
import ufrn.br.projetoaulaweb.service.generic.AbstractService;

import java.util.List;
import java.util.Optional;


@Service
public class PessoaJuridicaService extends AbstractService<PessoaJuridica, PessoaJuridicaRepository> {

    public PessoaJuridicaService(PessoaJuridicaRepository repository){
        super(repository);
    }

    /*
    public PessoaJuridica insert(PessoaJuridica p){
        return repository.save(p);
    }

    public PessoaJuridica update(PessoaJuridica p){
        return repository.save(p);
    }

    public void delete(PessoaJuridica p){
         repository.delete(p);
    }

    //salva e retorna o obj atualizado
    public PessoaJuridica saveAndFlush(PessoaJuridica p){
         return repository.saveAndFlush(p);
    }

    public Optional<PessoaJuridica> findById(Long id){
         return repository.findById(id);
    }

    public List<PessoaJuridica> listAll(){
         return repository.findAll();
    } */
}
