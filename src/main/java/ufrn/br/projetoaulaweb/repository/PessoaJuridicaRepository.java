package ufrn.br.projetoaulaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.projetoaulaweb.model.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
}
