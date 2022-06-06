package ufrn.br.projetoaulaweb.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class EnderecoDtoRequest implements Serializable {

    String logradouro;
    String bairro;
    String numero;
    String cep;
    String cidade;
    String uf;
    //Pessoa pessoa;

}
