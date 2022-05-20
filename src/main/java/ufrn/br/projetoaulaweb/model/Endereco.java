package ufrn.br.projetoaulaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.envers.Audited;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Audited
public class Endereco extends AbstractEntity {

    String logradouro;
    String bairro;
    String numero;
    String cep;
    String cidade;
    String uf;

  /*  @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore */

    @OneToOne(mappedBy="endereco", cascade = CascadeType.MERGE)
    @JsonIgnore
    Pessoa pessoa;

}
