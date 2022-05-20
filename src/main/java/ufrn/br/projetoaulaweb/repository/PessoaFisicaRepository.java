package ufrn.br.projetoaulaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import ufrn.br.projetoaulaweb.repository.generic.GenericRepository;
@Repository
public interface PessoaFisicaRepository extends GenericRepository<PessoaFisica> {
    //terá todos os métodos de genericRepository. Poderei adicionar os métodos particulares. Ex:
    //public PessoaFisica findUserByName(String name);
}
