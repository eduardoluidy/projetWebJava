package ufrn.br.projetoaulaweb.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

@NoArgsConstructor
@Getter
@Setter
public class PessoaJuridicaDtoRequest extends AbstractEntity {
    String nome;
    String email;
    String senha;
    String telefone;
    String cnpj;
    Endereco endereco;

}
