package ufrn.br.projetoaulaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.projetoaulaweb.model.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {
}
