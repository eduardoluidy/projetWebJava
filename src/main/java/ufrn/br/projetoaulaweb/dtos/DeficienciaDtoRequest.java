package ufrn.br.projetoaulaweb.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class DeficienciaDtoRequest implements Serializable {

    String tipoDeficiencia;
    String descricaoLaudo;
    Date dataLaudo;

    //List<PessoaFisica> pessoasfisicas;

}
