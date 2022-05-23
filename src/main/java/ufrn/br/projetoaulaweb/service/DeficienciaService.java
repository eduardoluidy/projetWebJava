package ufrn.br.projetoaulaweb.service;

import org.springframework.stereotype.Service;
import ufrn.br.projetoaulaweb.model.Deficiencia;
import ufrn.br.projetoaulaweb.repository.DeficienciaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DeficienciaService {

    protected final DeficienciaRepository deficienciaRepository;

    public DeficienciaService(DeficienciaRepository deficienciaRepository) {
        this.deficienciaRepository = deficienciaRepository;
    }

    public List<Deficiencia> findAll(){
        return deficienciaRepository.findAll();
    }

    public Optional<Deficiencia> findById(Long id){
        return deficienciaRepository.findById(id);
    }

    @Transactional
    public Deficiencia create(Deficiencia deficiencia) {
        return deficienciaRepository.save(deficiencia);
    }

    @Transactional
    public boolean delete(Long id) {
        return deficienciaRepository.findById(id)
                .map(record -> {
                    deficienciaRepository.deleteById(id);

                    return true;
                }).orElse(false);
    }
}
