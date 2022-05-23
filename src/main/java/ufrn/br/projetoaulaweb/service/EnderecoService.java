package ufrn.br.projetoaulaweb.service;


import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.repository.EnderecoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    protected final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(Long id){
        return enderecoRepository.findById(id);
    }

    @Transactional
    public Endereco create(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public boolean delete(Long id) {
        return enderecoRepository.findById(id)
                .map(record -> {
                    enderecoRepository.deleteById(id);

                    return true;
                }).orElse(false);
    }
}
