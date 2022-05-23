package ufrn.br.projetoaulaweb.service;

import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.repository.PessoaFisicaRepository;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class PessoaFisicaService  {

    protected final PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisicaService(PessoaFisicaRepository repository){
        this.pessoaFisicaRepository = repository;
    }

    public Page<PessoaFisica> findAll(Pageable pageable){
        return pessoaFisicaRepository.findAll(pageable);
    }

    public Optional<PessoaFisica> findById(Long id){
        return pessoaFisicaRepository.findById(id);
    }

    @Transactional
    public PessoaFisica create(PessoaFisica pessoaFisica) {
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    @Transactional
    public boolean delete(Long id) {
        return pessoaFisicaRepository.findById(id)
                .map(record -> {
                    pessoaFisicaRepository.deleteById(id);

                    return true;
                }).orElse(false);
    }
}
