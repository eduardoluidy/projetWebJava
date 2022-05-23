package ufrn.br.projetoaulaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufrn.br.projetoaulaweb.model.Deficiencia;

@Repository
public interface DeficienciaRepository extends JpaRepository<Deficiencia, Long> {

}
