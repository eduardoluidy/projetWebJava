package ufrn.br.projetoaulaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@Audited
public class Dependente extends AbstractEntity {

    String nome;
    String parentesco;

    @ManyToOne
    @JoinColumn(name = "servidor_id")
    @JsonIgnore
    Servidor servidor;
}
