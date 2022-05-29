package ufrn.br.projetoaulaweb.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.projetoaulaweb.model.Pessoa;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class EnderecoDto implements Serializable {

    String logradouro;
    String bairro;
    String numero;
    String cep;
    String cidade;
    String uf;
    //Pessoa pessoa;

}
