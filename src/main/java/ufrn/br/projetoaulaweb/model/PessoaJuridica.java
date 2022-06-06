package ufrn.br.projetoaulaweb.model;

import lombok.*;
import org.hibernate.envers.AuditTable;
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
@AuditTable(value = "pessoa_juridica_aud")
public class PessoaJuridica extends Pessoa {
    //@Column(nullable = false, unique = true)
    String cnpj;

}
