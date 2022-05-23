package ufrn.br.projetoaulaweb.service;

import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.Vinculo;
import ufrn.br.projetoaulaweb.repository.VinculoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VinculoService {

    protected final VinculoRepository vinculoRepository;

    public VinculoService(VinculoRepository vinculoRepository) {
        this.vinculoRepository = vinculoRepository;
    }

    public List<Vinculo> findAll(){
        return vinculoRepository.findAll();
    }

    public Optional<Vinculo> findById(Long id){
        return vinculoRepository.findById(id);
    }

    @Transactional
    public Vinculo create(Vinculo vinculo) {
        return vinculoRepository.save(vinculo);
    }

    @Transactional
    public boolean delete(Long id) {
        return vinculoRepository.findById(id)
                .map(record -> {
                    vinculoRepository.deleteById(id);

                    return true;
                }).orElse(false);
    }
}
