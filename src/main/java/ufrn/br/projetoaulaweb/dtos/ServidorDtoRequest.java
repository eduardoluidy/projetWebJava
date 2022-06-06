package ufrn.br.projetoaulaweb.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.projetoaulaweb.model.Dependente;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.model.Vinculo;


import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ServidorDtoRequest implements Serializable {
    String nome;
    String email;
    String telefone;
    String cpf;
    String rg;
    Endereco endereco;
    List<Vinculo> vinculos;
    List<Dependente> dependentes;
}
