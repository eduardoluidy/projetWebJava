package ufrn.br.projetoaulaweb.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.projetoaulaweb.model.Deficiencia;
import ufrn.br.projetoaulaweb.model.Endereco;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class PessoaFisicaRequestDto implements Serializable {

    String nome;
    String email;
    //String senha;
    String telefone;
    String cpf;
    String rg;
    Endereco endereco;
    List<Deficiencia> deficiencias;

}
