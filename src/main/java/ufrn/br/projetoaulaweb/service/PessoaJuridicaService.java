package ufrn.br.projetoaulaweb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.PessoaJuridica;
import ufrn.br.projetoaulaweb.repository.PessoaJuridicaRepository;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class PessoaJuridicaService {

    protected final PessoaJuridicaRepository pessoaJuridicaRepository;
    public PessoaJuridicaService(PessoaJuridicaRepository pessoaJuridicaRepository){
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    public Page<PessoaJuridica> findAll(Pageable pageable){
        return pessoaJuridicaRepository.findAll(pageable);
    }

    public Optional<PessoaJuridica> findById(Long id){
        return pessoaJuridicaRepository.findById(id);
    }

    @Transactional
    public PessoaJuridica create(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    @Transactional
    public boolean delete(Long id) {
        return pessoaJuridicaRepository.findById(id)
                .map(record -> {
                    pessoaJuridicaRepository.deleteById(id);

                    return true;
                }).orElse(false);
    }
}


