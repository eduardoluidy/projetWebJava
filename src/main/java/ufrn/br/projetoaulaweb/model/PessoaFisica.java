package ufrn.br.projetoaulaweb.model;

import lombok.*;
import org.hibernate.envers.Audited;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Audited
public class PessoaFisica extends Pessoa {
    @Column(nullable = false, length = 11)
    String cpf;
    @Column(nullable = false)
    String rg;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pessoafisica_deficiencia",
            joinColumns = @JoinColumn(name = "pessoafisica_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "deficiencia_id")
    )
    List<Deficiencia> deficiencias;

}

