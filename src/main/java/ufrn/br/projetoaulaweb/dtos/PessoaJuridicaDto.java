package ufrn.br.projetoaulaweb.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class PessoaJuridicaDto extends AbstractEntity {
    String nome;
    String email;
    String senha;
    String telefone;
    String cnpj;
    Endereco endereco;

}
