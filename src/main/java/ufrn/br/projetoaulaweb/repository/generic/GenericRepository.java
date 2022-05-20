package ufrn.br.projetoaulaweb.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

//jpaRepository já traz alguns metodos prontos
public interface GenericRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {
}
