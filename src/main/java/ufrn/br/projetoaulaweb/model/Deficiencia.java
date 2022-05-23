package ufrn.br.projetoaulaweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Audited
@AuditTable(value = "deficiencia_aud")
public class Deficiencia extends AbstractEntity {
    String tipoDeficiencia;
    String descricaoLaudo;
    Date dataLaudo;

    @ManyToMany(mappedBy = "deficiencias")
    @JsonIgnore
    List<PessoaFisica> pessoasfisicas;

}
