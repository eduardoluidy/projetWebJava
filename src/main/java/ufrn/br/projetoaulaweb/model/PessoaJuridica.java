package ufrn.br.projetoaulaweb.model;

import lombok.*;
import org.hibernate.envers.Audited;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Audited
public class PessoaJuridica extends Pessoa {
    //@Column(nullable = false, length = 11)
    String cnpj;


   // @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    //@JoinColumn(name = "endereco_id")
   // Endereco endereco;

}
