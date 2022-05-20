package ufrn.br.projetoaulaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
@Audited
public class Servidor extends PessoaFisica {

    /*
    @ManyToMany(mappedBy = "servidores")
    @ToString.Exclude */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "servidor_vinculo",
        joinColumns = @JoinColumn(name = "servidor_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "vinculo_id")
    )
    List<Vinculo> vinculos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "servidor")
    List<Dependente> dependentes;

}
