package ufrn.br.projetoaulaweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Audited
@AuditTable(value = "vinculo_aud")
public class Vinculo extends AbstractEntity {

    private Long id;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    Date dataAdmissao;
    @NotBlank(message = "Cargo é obrigatório")
    String cargo;
    String matricula;
    String orgao;
    String setor;

   /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "servidor_vinculo",
            joinColumns = @JoinColumn(name = "vinculo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "servidor_id")
    ) */
    @ManyToMany(mappedBy = "vinculos")
    @JsonIgnore
    List<Servidor> servidores;


}
