package ufrn.br.projetoaulaweb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.Servidor;
import ufrn.br.projetoaulaweb.repository.ServidorRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ServidorService {
    protected final ServidorRepository servidorRepository;

    public ServidorService(ServidorRepository repository){
        this.servidorRepository = repository;
    }

    public Page<Servidor> findAll(Pageable pageable){
        return servidorRepository.findAll(pageable);
    }

    public Optional<Servidor> findById(Long id){
        return servidorRepository.findById(id);
    }

    @Transactional
    public Servidor create(Servidor servidor) {
        return servidorRepository.save(servidor);
    }

    @Transactional
    public boolean delete(Long id) {
        return servidorRepository.findById(id)
                .map(record -> {
                    servidorRepository.deleteById(id);

                    return true;
                }).orElse(false);
    }
}